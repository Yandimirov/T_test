import {Employee} from './employee';
import 'moment';
import moment = require('moment');

export class EmployeeDto {
  id: number;
  name: string;
  surName: string;
  birthDate: string;
  cityId: number;
  phoneNum: string;
  active: boolean;
  groupId: number;

  constructor(employee: Employee) {
    this.id = employee.id;
    this.name = employee.name;
    this.surName = employee.surName;
    this.phoneNum = employee.phoneNum;
    this.active = employee.active;
    this.birthDate = moment(employee.birthDate, 'yyyy-MM-dd').format();
    if (employee.city) {
      this.cityId = employee.city.id;
    }
    if (employee.group) {
      this.groupId = employee.group.id;
    }
  }
}
