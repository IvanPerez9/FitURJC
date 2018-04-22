import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import {MultipartUploader} from "../multipart-upload/multipart-uploader";
import {MultipartItem} from "../multipart-upload/multipart-item";
import * as globals from '../globals';
import { HttpResponse, HttpEventType } from '@angular/common/http';
import { UploadFileService } from '../multipart-upload/upload-service';



@Component({
  // tslint:disable-next-line:component-selector
  selector: 'app-editProfile',
  templateUrl: './editProfile.component.html',
  styleUrls: ['./editProfile.component.css']
})
export class EditProfileComponent implements OnInit {


  public editMode: number; // 0 nada 1 imagen 2 datos
  userUpdated: FormGroup;
  userLogged: User;
  editUser: userUpdated;
  error_updated: boolean;
  private file: File;
  private imageWellUploded: boolean;
  private imageResponse: boolean = false;
  notification: boolean;

  uploadImageFile: FormGroup;


  constructor(private userService: UserService, private router: Router, private uploadService: UploadFileService, private sessionService: LoginService) {
    this.userLogged = this.userService.getLoggedUser();
    this.editMode = 0;
  }

  ngOnInit() {
    if (!this.sessionService.isLogged()) {
      return this.router.navigate(['/login']);
    } else {
      console.log('Logged');
      this.userUpdated = new FormGroup({
        name: new FormControl(this.userLogged.name, Validators.required),
        surname: new FormControl(this.userLogged.surname, Validators.required),
        email: new FormControl(this.userLogged.email, Validators.required),
        age: new FormControl(this.userLogged.age, Validators.required)
      });
      this.uploadImageFile = new FormGroup({
        fileType: new FormControl('', Validators.required)
      });
      this.editMode = 0;
  }
  }

  /*onSubmit(form: FormGroup) {
    console.log(form.value);
    const valuesForm: any = form.value;
    this.userUpdated = valuesForm;
    this.userService.editUser(this.userLogged.id,this.userLogged).subscribe(
      result => {
        this.userService.setUserLogged(result);
        this.router.navigate(['/user/profile']);
      },
    error => {
      console.log(error);
      console.log(error.code);
      /!*if (error.status === 0) {
        this.error_signUp = true;
      } else if (error.status === 401) {
        this.error_signUp = true;
      } else if (error.status === 403) {
        this.error_signUp = true;
      } else if (error.status === 405) {
        this.error_signUp = true;
      }
    });*!/
    });
  }*/

  isLoggedUser() {
    if (this.sessionService.isLogged()) {
      return this.router.navigate(['/user/profile']);
    } else {
      console.log('Not Logged');
      return this.router.navigate(['/login']);
    }
  }

  onSubmit(idUserToEdit: number, form: FormGroup) {
    console.log(form.value);
    console.log(idUserToEdit);
    const valuesForm: any = form.value;
    this.editUser = valuesForm;
    this.userService.editUser(idUserToEdit, this.editUser).subscribe(
      result => {
        this.notification = true;
        setTimeout(() => {
        console.log(this.editUser);
        console.log(idUserToEdit);
        this.router.navigate(['/user/profile']);
        },3000);
      },
      error => {
        console.log(error.code);
      }
    );
  }
  changeEditMode(i:number) {
    this.editMode = i;
    console.log("Pasa por upload");
  }
  selectFile($event) {
    this.file = $event.target.files[0];
    console.debug("Imagen selected: " + this.file.name + " type:" + this.file.size + " size:" + this.file.size);
    console.log("Pasa por select");
  }

  uploadImage() {
    console.debug("Uploading file...");
    if (this.file == null){
      console.error("You have to select a file and set a description.");
      return;
    }

    let formData = new FormData();
    formData.append("file",  this.file);
    let multipartItem = new MultipartItem(new MultipartUploader({url: globals.BASEURL_IMAGE +'/api/image'}));
    multipartItem.formData = formData;

    multipartItem.callback = (data, status, headers) => {
      this.imageResponse = true;
      if (status == 201){
        this.imageWellUploded = true;
        this.userLogged.imgSrc = data;
        console.debug("File has been uploaded");
      } else {
        this.imageWellUploded = false;
        console.error("Error uploading file");
      }
    };
    multipartItem.upload();
  }

  getUriImage(uriImage: string): string {
    return globals.BASEURL_IMAGE + uriImage;
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
    this.isFile = undefined;
    this.uploadService.uploadFileBasic(this.file).subscribe(
      event => {
        if (event.type === HttpEventType.UploadProgress) {
        } else if (event instanceof HttpResponse) {
          console.log('File is completely uploaded!');
        }
      },
      error => {
        console.log(error);
        console.log(error.code);
        if (error.error.code === 15010) {
          console.log('Error, no existe el archivo');
        } else if (error.status === 400) {
          console.log('Error, no hay archivo');
             }
      });
  }

}

export interface userUpdated {
  name: string;
  surname: string;
  nickname: string;
  email: string;
  age: number;
}
