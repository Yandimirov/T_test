import {Component, OnInit} from '@angular/core';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/observable/fromEvent';
import {EmployeeService} from '../service/employee.service';
import {Employee} from '../model/employee';


@Component({
  selector: 'employees-table',
  styleUrls: ['./employees.component.css'],
  templateUrl: './employees.component.html'
})
export class EmployeesComponent implements OnInit {
  employees: Employee[];
  selectedEmployee: Employee;
  columns: any[];
  displayDialog: boolean = false;
  isNewEmployee: boolean = false;
  employee: Employee;
  pageSize = 10;
  pageIndex = 0;
  length = 0;

  constructor(private employeeService: EmployeeService) {

  }

  ngOnInit(): void {
    this.loadEmployees();
    this.columns = [
      {field: 'id', header: 'ID'},
      {field: 'name', header: 'Name'},
      {field: 'surName', header: 'Surname'},
      {field: 'birthDate', header: 'Birth date'},
      {field: 'active', header: 'Active'},
      {field: 'phoneNum', header: 'Phone Number'}
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

  onPageChange(event: any): void {
    this.pageIndex = event.page;
    this.pageSize = event.rows;
    this.loadEmployees();
  }

  showCreateDialog(): void {
    this.isNewEmployee = true;
    this.employee = new Employee();
    this.displayDialog = true;
  }

  onSelectEmployee(event: any): void {
    console.log(this.selectedEmployee);
    this.isNewEmployee = false;
    this.employee = new Employee();
    for (const field in this.selectedEmployee) {
      if (this.selectedEmployee[field]) {
        this.employee[field] = this.selectedEmployee[field];
      }
    }
    this.displayDialog = true;
  }

  save(): void {
    if (this.isNewEmployee) {

    } else {
      this.employeeService.updateEmployee(this.employee)
      .then(response => {
        let newEmployee = response.json();
        let employees = [...this.employees];
        let index = employees.findIndex(emp => emp.id === newEmployee.id);
        employees[index] = newEmployee;
        console.log(newEmployee);
        console.log(this.employee);
        this.employee = null;
        this.employees = employees;
      });
    }
    this.displayDialog = false;
  }

  delete(): void {

  }
}
