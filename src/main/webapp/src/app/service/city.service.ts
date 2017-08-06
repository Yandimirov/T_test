import {Injectable} from '@angular/core';
import {CITY_URL} from '../utils/urls';
import {Http} from '@angular/http';
import {City} from '../model/city';

@Injectable()
export class CityService {

  private cityUrl = CITY_URL;

  constructor(private http: Http) {
  }

  getCities(): Promise<City[]> {
    return this.http.get(this.cityUrl)
    .toPromise()
    .then(response => response.json() as City[])
    .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.log('An error occured', error);
    return Promise.reject(error.message || error);
  }
}
