import { FormGroup, FormControl, Validators } from '@angular/forms';
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
  isSuccess: boolean = false;
  selectedRole: string;
  selectedDep: string;

  rolls: Array<any> = ['Employee', 'Supervisor'];
  deps: Array<any> = [
    'Finance & Accounts',
    'Human Resources',
    'Production',
    'Purchasing',
    'Sales and marketing',
  ];

  constructor(private userService: EmployeeCreateService) {}

  ngOnInit(): void {}

  public registerNow() {
    this.user.department = this.selectedDep;
    this.user.roll = this.selectedRole;

    console.log(this.user);

    let res = this.userService.addEmp(this.user);
    res.subscribe(
      (data) => {
        if (data.code != 200) {
          this.isBad = true;
          this.isSuccess = false;
          this.message = data.msg;
        } else {
          this.isSuccess = true;
          this.isBad = false;
          this.message = ' Registration Success!';
          this.user.firstName = '';
          this.user.lastName = '';
          this.user.emailId = '';
          this.user.salary = '';
          this.user.address = '';
          this.user.department = '';
          this.user.salary = '';
        }
      },
      (err) => {
        this.isBad = true;
        this.isSuccess = false;
        this.message = 'Please ennter valid information';
      }
    );
  }

  changeRole(e) {
    console.log(e.target.value);
    this.selectedRole = e.target.value;
  }

  changeDep(e) {
    console.log('-->>>' + e.target.value);
    this.selectedDep = e.target.value;
  }

  form = new FormGroup({
    website: new FormControl('', Validators.required),
  });

  get f() {
    return this.form.controls;
  }
}
