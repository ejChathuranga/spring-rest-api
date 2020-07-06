import { Assignee } from './../../assignee';
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
  employees: Array<User>;
  showUpdateMode: boolean = false;
  selectedEmp: User;
  user: User = new User();
  message: string;
  showModel: boolean = false;
  selectedRole: string;
  selectedDep: string;
  supervisorName: string = '';
  supervisors: any;
  messageSuccess: string;
  isSuccess: boolean = false;
  assignedSupervisor: any;
  networkFail: boolean;
  messageFailed: string;

  title = 'appBootstrap';
  isBad: boolean = false;
  closeResult: string;

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

  ngOnInit(): void {
    this.getAll();
  }

  public getAll() {
    this.employeeList.getAll().subscribe(
      (data) => {
        // console.log(data);
        let arr = <User>data;
        let newArray = [];

        arr.forEach(function (element) {
          let user: User = new User();
          user.id = element.id;
          user.firstName = element.firstName;
          user.lastName = element.lastName;
          user.emailId = element.emailId;
          user.salary = element.salary;
          user.address = element.address;
          user.department = element.department;
          user.supervisor = element.supervisor;
          user.roll = element.roll;

          if (element.roll == 'Supervisor') {
            user.isSupervisor = true;
          } else {
            user.isSupervisor = false;
          }

          newArray.push(user);
        });

        this.employees = newArray;
      },
      (err) => {
        this.networkFail = true;
        this.messageFailed = 'Please check server is running or not!';
      }
    );
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

  public assignSupervisor(content, user: User) {
    this.selectedEmp = user;
    let resAssignee = this.employeeList.getSupervisor(user.id);

    resAssignee.subscribe(
      (res) => {
        console.log(res);
        this.assignedSupervisor = res;
        this.getAllSupervisors(content);
      },
      (err) => {
        console.log(err);
      }
    );

    this.showModel = true;
    this.user = user;
  }

  getAllSupervisors(content) {
    let resAllSups = this.employeeList.getAllSuperes(this.supervisorName);

    resAllSups.subscribe(
      (data) => {
        // console.log(data);
        this.supervisors = data;

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
      },
      (err) => {
        console.log(err);
      }
    );
  }

  assignSupervisorToUser(supervisor: User) {
    console.log(supervisor);
    let assignee: Assignee = new Assignee();
    assignee.userId = this.selectedEmp.id;
    assignee.supervisorId = supervisor.id;
    console.log(assignee);
    let res = this.employeeList.addAssignee(assignee);

    res.subscribe(
      (data) => {
        this.isSuccess = true;
        this.messageSuccess = 'Successfully updated the user';
        this.modalService.dismissAll();
        this.getAll();
      },
      (err) => {
        console.log(err);
      }
    );
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
