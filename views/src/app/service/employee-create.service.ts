import { Assignee } from './../assignee';
import { Const } from './../const';
import { User } from './../user';
import { HttpClient } from '@angular/common/http';
import { Injectable, EventEmitter } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class EmployeeCreateService {
  const: Const;

  constructor(private http: HttpClient) {
    this.const = new Const();
  }

  public addEmp(user: User) {
    return this.http.post<any>(this.const.host, user, {
      responseType: 'json',
    });
  }

  public getAll() {
    return this.http.get(this.const.host);
  }

  public deleteEmp(id: number) {
    return this.http.delete<any>(this.const.host + id);
  }

  public updateEmp(id: number, user: User) {
    return this.http.put<any>(this.const.host + id, user);
  }

  public getAllSuperes(name: string) {
    return this.http.get(this.const.baseHost + 'assignee');
  }

  public addAssignee(assigne: Assignee) {
    return this.http.post<any>(this.const.baseHost + 'assignee', assigne);
  }

  public getSupervisor(userId: number) {
    return this.http.get(this.const.baseHost + 'assignee/user/' + userId);
  }
}
