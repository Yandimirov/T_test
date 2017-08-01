import {Component, OnInit} from '@angular/core';
import {DataSource} from '@angular/cdk';
import {BehaviorSubject} from 'rxjs/BehaviorSubject';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/startWith';
import 'rxjs/add/observable/merge';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/debounceTime';
import 'rxjs/add/operator/distinctUntilChanged';
import 'rxjs/add/observable/fromEvent';
import {Employee} from '../model/employee';
import {EmployeeService} from '../service/employee.service';

@Component({
  selector: 'employees-table',
  styleUrls: ['./employees.component.css'],
  templateUrl: './employees.component.html'
})
export class EmployeesComponent implements OnInit {
  displayedColumns = [
    'employeeId',
    'employeeName',
    'employeeSurName',
    'employeePhone',
    'employeeBithDate',
    'employeeActive'
  ];
  employeeDataSource: EmployeeDataSource | null;

  constructor(private employeeService: EmployeeService) {

  }

  ngOnInit(): void {
    this.employeeDataSource = new EmployeeDataSource(this.employeeService);
  }
}

export class EmployeeDataSource extends DataSource<Employee> {
  employees: BehaviorSubject<Employee[]> = new BehaviorSubject<Employee[]>([]);

  constructor(private employeeService: EmployeeService) {
    super();
    this.employeeService.getEmployees().then(response => {
      this.employees.next(response);
    });
  }

  connect(): Observable<Employee[]> {
    return this.employees;
  }

  disconnect() {
  }
}
