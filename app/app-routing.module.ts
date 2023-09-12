import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BusListComponent } from './bus-list/bus-list.component';
import {CreateBusComponent } from './create-bus/create-bus.component';
import { UpdateBusComponent } from './update-bus/update-bus.component';
import { BusDetailsComponent } from './bus-details/bus-details.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { AuthGaurdServiceService } from './auth-gaurd-service.service';
//import { SearchServicesComponent } from './search-services/search-services.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { AuthenticationServiceService } from './authenticaton-service.service';
import { FeedbackComponent } from './feedback/feedback.component';
import { UserListComponent } from './user-list/user-list.component';
import { BookbusComponent } from './book-bus/book-bus.component';
import { SingupComponent } from './singup/singup.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { DriverListComponent } from './driver-list/driver-list.component';
import { CreateDriverComponent } from './create-driver/create-driver.component';
import { DriverDetailsComponent } from './driver-details/driver-details.component';
import { UpdateDriverComponent } from './update-driver/update-driver.component';




const routes: Routes = [
  {path: 'bus', component: BusListComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'create-bus', component: CreateBusComponent,canActivate:[AuthGaurdServiceService]},
 //{path: '', redirectTo: 'bus', pathMatch: 'full',canActivate:[AuthGaurdServiceService]},
  //{path:'search-service',component : SearchServicesComponent} ,
  {path: 'update-bus/:busId', component: UpdateBusComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'bus-details/:busId', component: BusDetailsComponent,canActivate:[AuthGaurdServiceService]},
  {path: 'home', component: HomeComponent,},
  {path: 'login', component: LoginComponent},
  { path: 'logout', component: LogoutComponent},
  {path:'contact-us',component:ContactUsComponent},
  {path:'about-us',component:AboutUsComponent,canActivate:[AuthGaurdServiceService]},
  {path:'feedback',component:FeedbackComponent},
  {path:'book-bus/:busId',component:BookbusComponent,canActivate:[AuthGaurdServiceService]},
  {path:'user-list/:busId',component:UserListComponent,canActivate:[AuthGaurdServiceService]},
  {path:'singup',component:SingupComponent,canActivate:[AuthGaurdServiceService]},
  {path:'user-details/:userID',component:UserDetailsComponent,canActivate:[AuthGaurdServiceService]},
  {path:'driver-list',component:DriverListComponent,canActivate:[AuthGaurdServiceService]},
  {path:'create-driver',component:CreateDriverComponent,canActivate:[AuthGaurdServiceService]},
  {path:'driver-details/:driverId',component:DriverDetailsComponent,canActivate:[AuthGaurdServiceService]},
  {path:'update-driver/:driverId',component:UpdateDriverComponent,canActivate:[AuthGaurdServiceService]}
 

  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],                                                                                                                                                                                                                                                                                                          
  exports: [RouterModule]
})
export class AppRoutingModule { }