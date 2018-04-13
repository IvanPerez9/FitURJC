import { Component, OnInit } from '@angular/core';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor( private http: HttpClientBasicAuth) { }

  ngOnInit() {
    this.http.logOut();
    // Make sure there are no users logged
  }

}
