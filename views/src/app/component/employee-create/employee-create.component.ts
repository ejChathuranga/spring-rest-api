import { EmployeeCreateService } from './../../service/employee-create.service';
import { User } from './../../user';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css'],
})
export class EmployeeCreateComponent implements OnInit {
  user: User = new User('', '', '', '', '', 1, 2);
  message: any;

  constructor(private userService: EmployeeCreateService) {}

  ngOnInit(): void {}

  public registerNow() {
    let res = this.userService.addEmp(this.user);
    res.subscribe((data) => (this.message = data));
  }
}
