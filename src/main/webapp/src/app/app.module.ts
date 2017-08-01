import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './component/app.component';
import {EmployeesComponent} from './component/employees.component';
import {CdkTableModule} from '@angular/cdk';
import {MdInputModule, MdTableModule} from '@angular/material';
import {NoopAnimationsModule} from '@angular/platform-browser/animations';
import {EmployeeService} from './service/employee.service';
import {HttpModule} from '@angular/http';

@NgModule({
  imports: [
    BrowserModule,
    CdkTableModule,
    MdTableModule,
    MdInputModule,
    HttpModule,
    NoopAnimationsModule
  ],
  declarations: [
    AppComponent,
    EmployeesComponent
  ],
  bootstrap: [AppComponent],
  providers: [EmployeeService]
})
export class AppModule {
}
