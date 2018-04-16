import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { LoginService } from '../../login/login.service';
import { User } from '../../user/user.model';
import { UserService } from '../../user/user.service';
import { AdminControlUsersService } from '../admin-control-users/admin-control-users.service';

@Component({
  selector: 'app-admin-control-users',
  templateUrl: './admin-control-users.component.html',
  styleUrls: ['./admin-control-users.component.css']
})
export class AdminControlUsersComponent implements OnInit {

  users: User[];

  constructor(private router: Router, private userService: UserService, private loginService: LoginService, 
    private adminUserService: AdminControlUsersService) {}

   ngOnInit() {
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
    this.adminUserService.deleteUser(id).subscribe(
      response => {
        console.log("Borrado");
        this.router.navigate(['/admin/controlUsers']);
      },
      error => {
        console.log(error);
        console.log(error.code);
        console.log("Fallo");
      }
    );
  }
}