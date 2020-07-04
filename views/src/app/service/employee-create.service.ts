import { User } from './../user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EmployeeCreateService {
  constructor(private http: HttpClient) {}

  public addEmp(user: User) {
    return this.http.post('http://localhost:8080/api/v2/employee', user, {
      responseType: 'text' as 'json',
    });
  }
}
