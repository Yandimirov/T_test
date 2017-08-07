import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/observable/fromEvent';
import {EmployeeService} from '../service/employee.service';
import {Employee} from '../model/employee';
import {CityService} from '../service/city.service';
import {SelectItem} from 'primeng/primeng';
import {GroupService} from '../service/group.service';


@Component({
  selector: 'employees-table',
  styleUrls: ['./employees.component.css'],
  templateUrl: './employees.component.html',
})
export class EmployeesComponent implements OnInit {
  employees: Employee[];
  cities: SelectItem[];
  groups: SelectItem[];
  selectedEmployee: Employee;
  columns: any[];
  displayDialog: boolean = false;
  isNewEmployee: boolean = false;
  employee: Employee;
  pageSize = 10;
  pageIndex = 0;
  length = 0;
  cityId: number = null;
  groupId: number = null;

  constructor(private employeeService: EmployeeService,
              private cityService: CityService,
              private groupService: GroupService) {
  }

  ngOnInit(): void {
    this.loadEmployees();
    this.loadCities();
    this.columns = [
      {field: 'id', header: 'ID'},
      {field: 'name', header: 'Name'},
      {field: 'surName', header: 'Surname'},
      {field: 'birthDate', header: 'Birth date'},
      {field: 'active', header: 'Active'},
      {field: 'phoneNum', header: 'Phone Number'},
      {field: 'city.name', header: 'City'},
      {field: 'group.name', header: 'Group'}
    ];
  }

  loadEmployees(): void {
    this.employeeService.getEmployees(this.pageIndex, this.pageSize)
    .then(response => {
      console.log(response);
      this.employees = response.json().content;
      this.length = response.json().totalElements;
    });
  }

  loadCities(): void {
    this.cityService.getCities()
    .then(response => {
      this.cities = response.map(city => {
        return {
          label: city.name,
          value: city.id
        };
      });
    });
  }

  onPageChange(event: any): void {
    this.pageIndex = event.page;
    this.pageSize = event.rows;
    this.loadEmployees();
  }

  showCreateDialog(): void {
    this.isNewEmployee = true;
    this.employee = new Employee();
    this.cityId = null;
    this.displayDialog = true;
  }

  onSelectEmployee(event: any): void {
    this.isNewEmployee = false;
    this.employee = new Employee();
    for (const field in this.selectedEmployee) {
      if (this.selectedEmployee[field]) {
        this.employee[field] = this.selectedEmployee[field];
      }
    }
    this.cityId = this.employee.city.id;
    console.log(this.cityId);
    this.displayDialog = true;
  }

  save(): void {
    if (this.isNewEmployee) {

    } else {
      this.employeeService.updateEmployee(this.employee)
      .then(response => {
        let newEmployee = response.json();
        let employees = [...this.employees];
        let index = this.findIndexOfEmployee(newEmployee);
        if (index !== -1) {
          employees[index] = newEmployee;
          console.log(newEmployee);
          console.log(this.employee);
          this.employee = null;
          this.employees = employees;
        }
      });
    }
    this.displayDialog = false;
  }

  delete(): void {
    if (this.selectedEmployee) {
      this.employeeService.deleteEmployee(this.selectedEmployee)
      .then(response => {
        if (response.ok) {
          let copiedEmployees = [...this.employees];
          let index = this.findIndexOfEmployee(this.selectedEmployee);
          if (index !== -1) {
            copiedEmployees.splice(index, 1);
            this.employees = copiedEmployees;
          }
        }
      });
    }
    this.displayDialog = false;
  }

  private findIndexOfEmployee(employee: Employee) {
    return this.employees.findIndex(emp => emp.id === employee.id);
  }
}
