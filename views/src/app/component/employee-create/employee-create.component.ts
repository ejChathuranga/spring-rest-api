import { EmployeeCreateService } from './../../service/employee-create.service';
import { User } from './../../user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css'],
})
export class EmployeeCreateComponent implements OnInit {
  user: User = new User();
  message: any;
  isBad: boolean = false;

  constructor(private userService: EmployeeCreateService) {}

  ngOnInit(): void {}

  public registerNow() {
    let res = this.userService.addEmp(this.user);
    res.subscribe((data) => {
      if (data.code != 200) {
        this.isBad = true;
        this.message = data.msg;
      } else {
        this.isBad = false;
      }
    });
  }
}
