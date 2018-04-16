import {Injectable} from '@angular/core';
import {HttpClientBasicAuth} from '../HttpClient/httpClient';
import {Observable} from 'rxjs/Observable';
// tslint:disable-next-line:import-blacklist
import 'rxjs/Rx';
import * as globals from '../globals';
import {FacilitiesComponent} from "./facilities.component";

import {LoginService} from '../login/login.service';
import {User} from '../user/user.model';

@Injectable()
export class FacilitiesService {


  //Constructor
  constructor(private http: HttpClientBasicAuth, private loginService: LoginService) {
    console.log('Facilities service is running');
  }

  getFacilities(page: number): Observable<any> {
    let url = globals.FACILITIES_BASEURL + "?page=" + page +"&size=6";
    return this.http.get(url);
  }
}
