import {Injectable} from '@angular/core';

import {Headers, Http} from '@angular/http';
import 'rxjs/add/operator/toPromise';
import {Employee} from '../model/employee';
import {EMPLOYEE_URL} from '../utils/urls';

@Injectable()
export class EmployeeService {

  private employeesUrl = EMPLOYEE_URL;

  private headers = new Headers({'Content-Type': 'application/json'});

  constructor(private http: Http) {
  }

  getEmployees(): Promise<Employee[]> {
    return this.http.get(this.employeesUrl)
    .toPromise()
    .then(response => {
      return response.json().content as Employee[]
    })
    .catch(this.handleError);
  }

  getEmployee(id: number): Promise<Employee> {
    const url = `${this.employeesUrl}/${id}`;
    return this.http.get(url)
    .toPromise()
    .then(response => {
      return response.json().data as Employee
    })
    .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.log('An error occured', error);
    return Promise.reject(error.message || error);
  }
}
