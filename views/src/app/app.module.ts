import { EmployeeCreateService } from './service/employee-create.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule, FormBuilder } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/home/home.component';
import { EmployeeListComponent } from './component/employee-list/employee-list.component';
import { EmployeeCreateComponent } from './component/employee-create/employee-create.component';
import { HeaderComponent } from './component/header/header.component';
import { EmployeeUpdateComponent } from './component/employee-update/employee-update.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    EmployeeListComponent,
    EmployeeCreateComponent,
    HeaderComponent,
    EmployeeUpdateComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NgbModule,
  ],
  providers: [EmployeeCreateService, FormBuilder],
  bootstrap: [AppComponent],
  entryComponents: [EmployeeUpdateComponent],
})
export class AppModule {}
