import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './component/app.component';
import {EmployeesComponent} from './component/employees.component';
import {EmployeeService} from './service/employee.service';
import {HttpModule} from '@angular/http';
import {CommonModule} from '@angular/common';
import {
  DataTableModule, SharedModule, PaginatorModule,
  ButtonModule, DialogModule, InputTextModule,
  DropdownModule, ToggleButtonModule, CalendarModule
} from 'primeng/primeng';
import {FormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {CityService} from './service/city.service';
import {GroupService} from './service/group.service';

@NgModule({
  imports: [
    BrowserModule,
    HttpModule,
    CommonModule,
    SharedModule,
    DataTableModule,
    PaginatorModule,
    ButtonModule,
    DialogModule,
    FormsModule,
    BrowserAnimationsModule,
    InputTextModule,
    DropdownModule,
    ToggleButtonModule,
    CalendarModule
  ],
  declarations: [
    AppComponent,
    EmployeesComponent
  ],
  bootstrap: [AppComponent],
  providers: [
    EmployeeService,
    CityService,
    GroupService
  ]
})
export class AppModule {
}
