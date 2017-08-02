import {Employee} from './employee';

export class EmployeeDto {
  id: number;
  name: string;
  surName: string;
  birthDate: Date;
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
    this.birthDate = employee.birthDate;
    if (employee.city) {
      this.cityId = employee.city.id;
    }
    if (employee.group) {
      this.groupId = employee.group.id;
    }
  }
}
