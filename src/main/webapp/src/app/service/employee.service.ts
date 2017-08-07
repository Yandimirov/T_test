import {Injectable} from '@angular/core';

import {Http, Headers} from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {Employee} from '../model/employee';
import {EMPLOYEE_URL} from '../utils/urls';
import {EmployeeDto} from '../model/employee.dto';

@Injectable()
export class EmployeeService {

  private employeesUrl = EMPLOYEE_URL;
  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {
  }

  getEmployees(pageIndex: number, pageSize: number): Promise<any> {
    const url =
      `${this.employeesUrl}?page=${pageIndex}&size=${pageSize}`;
    return this.http.get(url)
    .toPromise()
    .then(response => response)
    .catch(this.handleError);
  }

  updateEmployee(employee: Employee): Promise<any> {
    if (employee) {
      const url = `${this.employeesUrl}/${employee.id}`;
      let employeeDto = new EmployeeDto(employee);
      return this.http.put(url, JSON.stringify(employeeDto),
        {headers: this.headers})
      .toPromise()
      .then(response => response)
      .catch(this.handleError);
    }
  }

  deleteEmployee(employee: Employee): Promise<any> {
    if (employee) {
      const url = `${this.employeesUrl}/${employee.id}`;
      return this.http.delete(url)
      .toPromise()
      .then(response => response)
      .catch(this.handleError);
    }
  }

  getEmployee(id: number): Promise<Employee> {
    const url = `${this.employeesUrl}/${id}`;
    return this.http.get(url)
    .toPromise()
    .then(response => {
      return response.json().data as Employee;
    })
    .catch(this.handleError);
  }

  createEmployee(employee: Employee): Promise<any> {
    let employeeDto = new EmployeeDto(employee);
    return this.http.post(this.employeesUrl,
      JSON.stringify(employeeDto),
      {headers: this.headers})
    .toPromise()
    .then(response => response)
    .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.log('An error occured', error);
    return Promise.reject(error.message || error);
  }
}
