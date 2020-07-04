import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class HomeService {
  employees = [
    {
      id: 101,
      name: 'Emp 01',
      desc: 'The testing userr 01',
      email: 'emp1@emp.com',
    },
    {
      id: 102,
      name: 'Emp 02',
      desc: 'The testing userr 02',
      email: 'emp2@emp.com',
    },
    {
      id: 103,
      name: 'Emp 03',
      desc: 'The testing userr 03',
      email: 'emp3@emp.com',
    },
    {
      id: 104,
      name: 'Emp 04',
      desc: 'The testing userr 04',
      email: 'emp4@emp.com',
    },
  ];

  constructor() {}

  public getEmp(): Array<{ id; name; desc; email }> {
    return this.employees;
  }

  public createEmp(emp: { id; name; desc; email }) {
    this.employees.push(emp);
  }
}
