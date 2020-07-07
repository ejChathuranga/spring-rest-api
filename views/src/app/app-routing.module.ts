import { EmployeeUpdateComponent } from './component/employee-update/employee-update.component';
import { EmployeeCreateComponent } from './component/employee-create/employee-create.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import { HomeComponent } from './component/home/home.component';
import { NgModule, Component } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  { path: '', pathMatch: 'full', redirectTo: '/add-employee' },
  { path: 'home', component: EmployeeCreateComponent },
  { path: 'all', component: EmployeeListComponent },
  { path: 'add-employee', component: EmployeeCreateComponent },
  { path: 'update-employee', component: EmployeeUpdateComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
