import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { HttpResponse, HttpEventType } from '@angular/common/http';
import { UploadFileService } from './upload-service';


export class MultipartUpload implements OnInit {


    file: File;
    fileUploaded: boolean;
    noFile: boolean;
    fileExists: boolean;
    constructor(private uploadService: UploadFileService) {
    }

    ngOnInit(): void {
        throw new Error('Method not implemented.');
    }

    isFile(): boolean {
        if (this.file === undefined) {
        return false;
        }
        if (this.file !== null) {
        return true;
        }
        return false;
    }

    uploadFileBasic(form: FormGroup) {
        this.noFile = false;
        this.fileExists = false;
        this.isFile = undefined;
        this.uploadService.uploadFileBasic(this.file).subscribe(
          event => {
            if (event.type === HttpEventType.UploadProgress) {
            } else if (event instanceof HttpResponse) {
              console.log('File is completely uploaded!');
              this.fileUploaded = true;
            }
          },
          error => {
            console.log(error);
            console.log(error.code);
            if (error.error.code === 15010) {
              this.fileExists = true;
            } else if (error.status === 400) {
              this.noFile = true;
                 }
          });
      }

}
