import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../login/login.service';
import { User } from '../user/user.model';
import { UserService } from '../user/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

import * as globals from '../globals';
import { HttpResponse, HttpEventType } from '@angular/common/http';
import { UploadFileService } from './upload-service';



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


  // tslint:disable-next-line:max-line-length
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
          this.router.navigate(['/']);
        }, 3000);
      },
      error => {
        console.log(error.code);
      }
    );
  }

  selectFile($event) {
    this.file = $event.target.files[0];
    console.debug("Imagen selected: " + this.file.name + " type:" + this.file.size + " size:" + this.file.size);
    console.log("Pasa por select");
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

  uploadFileBasic(file: File) {
    // this.isFile = undefined;
    this.uploadService.uploadFile(this.file).subscribe(
      event => {
        this.userService.updateUser().subscribe(
          result => {
            this.userService.setUserLogged(result);
            setTimeout(() => {
              this.router.navigate(['/user/profile']);
            },
              2000);
          },
          error => {
            console.log(error);
          });
      },
      error => {
        console.log(error);
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
