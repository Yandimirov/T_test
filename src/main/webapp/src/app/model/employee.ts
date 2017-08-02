import {City} from './city';
import {Group} from './group';

export class Employee {
  id: number;
  name: string;
  surName: string;
  birthDate: Date;
  active: boolean;
  phoneNum: string;
  city: City;
  group: Group;
}
