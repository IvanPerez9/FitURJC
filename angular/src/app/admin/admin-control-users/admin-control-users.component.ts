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
  userDelete: boolean;

  constructor(private router: Router, private userService: UserService, private loginService: LoginService,
    private adminControlUsersService: AdminControlUsersService) {

  }

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
}