import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../../login/login.service';
import { User } from '../../user/user.model';
import { UserService } from '../../user/user.service';
import { AdminControlUsersService } from '../admin-control-users/admin-control-users.service';
import { Validators, FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-admin-control-users',
  templateUrl: './admin-control-users.component.html',
  styleUrls: ['./admin-control-users.component.css']
})
export class AdminControlUsersComponent implements OnInit {

  users: User[];
  userDelete: boolean;
  adminEditUser: FormGroup;
  editUser: AdminEditUser;

  constructor(private router: Router, private userService: UserService, private loginService: LoginService,
    private adminControlUsersService: AdminControlUsersService) {

  }

  ngOnInit() {
    this.initUser();

     this.adminEditUser = new FormGroup({
      name: new FormControl('', Validators.required),
      surname: new FormControl('', Validators.required),
      email: new FormControl('', Validators.required),
      age: new FormControl('', Validators.required)
    });
  }

  initUser() {
    this.userService.getUsers().subscribe(
      user => {
        this.users = user;
      },
      error => {
        console.log(error);
      }
    );
  }

  deleteThisUser(id: number) {
    this.adminControlUsersService.deleteUser(id).subscribe(
      response => {
        this.userDelete = true;
        setTimeout(() => {
          this.router.navigate(['/admin']);
        }, 2000);
        console.log("Borrado");
      },
      error => {
        console.log(error);
        console.log(error.code);
        console.log("Fallo");
      }
    );
  }

 onSubmit(idUserToEdit: number, form: FormGroup) {
   console.log(form.value);
   console.log(idUserToEdit);
   const valuesForm: any = form.value;
   this.editUser = valuesForm;
   this.adminControlUsersService.editUser(idUserToEdit, this.editUser).subscribe(
     result => {
      console.log(this.editUser);
      console.log(idUserToEdit);
      this.router.navigate(['/admin']);
     },
     error => {
       console.log(error.code);
       }
     );
   }
}

 // tslint:disable-next-line:class-name
 export interface AdminEditUser {
   name: string;
   surname: string;
   nickname: string;
   email: string;
   age: number;
 }
