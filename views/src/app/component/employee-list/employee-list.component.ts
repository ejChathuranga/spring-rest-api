import { FormGroup, FormControl, Validators } from '@angular/forms';
import { User } from './../../user';
import { EmployeeCreateService } from './../../service/employee-create.service';
import { Component, OnInit } from '@angular/core';

import { NgbModal, ModalDismissReasons } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css'],
})
export class EmployeeListComponent implements OnInit {
  employees: any;
  showUpdateMode: boolean = false;
  selectedEmp: User;
  user: User = new User();
  message: string;
  showModel: boolean = false;
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

  constructor(
    private employeeList: EmployeeCreateService,
    private modalService: NgbModal
  ) {}

  title = 'appBootstrap';
  isBad: boolean = false;

  closeResult: string;

  ngOnInit(): void {
    this.getAll();
  }

  public getAll() {
    this.employeeList.getAll().subscribe((data) => {
      this.employees = data;
    });
  }

  public showUpdateEmp(content, user: User) {
    this.showModel = true;
    this.user = user;
    this.modalService
      .open(content, { ariaLabelledBy: 'modal-basic-title' })
      .result.then(
        (result) => {
          this.closeResult = `Closed with: ${result}`;
        },
        (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }

  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return `with: ${reason}`;
    }
  }

  public registerNow() {
    if (
      this.selectedDep == 'Choose Role' ||
      this.selectedRole == 'Choose Role'
    ) {
      this.isBad = true;
      this.message = 'Please select valid information';
      return;
    }
    this.isBad = false;
    this.user.department = this.selectedDep;
    this.user.roll = this.selectedRole;
    console.log(this.user);
    let res = this.employeeList.updateEmp(this.user.id, this.user);
    res.subscribe(
      (data) => {
        console.log(data);
        if (data.code != 200) {
          this.isBad = true;
          this.message = data.msg;
        } else {
          this.selectedDep = 'Choose Role';
          this.selectedRole = 'Choose Role';
          this.modalService.dismissAll();
          this.getAll();
        }
      },
      (err) => {
        console.log(err);

        this.isBad = true;
        this.message = 'Please ennter valid information';
      }
    );
  }

  contact_form = new FormGroup({
    website: new FormControl('', Validators.required),
  });

  get f() {
    return this.contact_form.controls;
  }

  changeRole(e) {
    console.log(e.target.value);
    this.selectedRole = e.target.value;
  }

  changeDep(e) {
    console.log('-->>>' + e.target.value);
    this.selectedDep = e.target.value;
  }

  public deleteEmp(id: number) {
    this.employeeList.deleteEmp(id).subscribe((data) => {
      console.log(data);
      this.getAll();
    });
  }
}
