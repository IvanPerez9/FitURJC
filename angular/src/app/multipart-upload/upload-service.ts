import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { HttpClientBasicAuth } from '../HttpClient/httpClient';
import { HttpEvent } from '@angular/common/http';

import * as globals from '../globals';

@Injectable()
export class UploadFileService {

  constructor(private http: HttpClientBasicAuth) { }

  uploadFileBasic(file: File) {
    let formdata: FormData = new FormData();
    formdata.append('file', file, file.name);
    return this.http.sendImage(globals.BASEURL_IMAGE , formdata);

  }

}
