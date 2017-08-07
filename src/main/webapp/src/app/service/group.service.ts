import {Injectable} from '@angular/core';
import {GROUP_URL} from '../utils/urls';
import {Http} from '@angular/http';
import {Group} from '../model/group';

@Injectable()
export class GroupService {

  private groupUrl = GROUP_URL;

  constructor(private http: Http) {
  }

  getGroups(): Promise<Group[]> {
    return this.http.get(this.groupUrl)
    .toPromise()
    .then(response => response.json() as Group[])
    .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.log('An error occured', error);
    return Promise.reject(error.message || error);
  }
}
