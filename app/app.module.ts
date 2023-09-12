import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BusDetailsComponent } from './bus-details/bus-details.component';
import { CreateBusComponent } from './create-bus/create-bus.component';
import { BusListComponent } from './bus-list/bus-list.component';
import { UpdateBusComponent } from './update-bus/update-bus.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ContactUsComponent } from './contact-us/contact-us.component';
import { LoginComponent } from './login/login.component';
import { LogoutComponent } from './logout/logout.component';
import { FeedbackComponent } from './feedback/feedback.component';
import { BookbusComponent } from './book-bus/book-bus.component';
import { UserListComponent } from './user-list/user-list.component';
import { SingupComponent } from './singup/singup.component';
import { AdminComponent } from './admin/admin.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { CreateDriverComponent } from './create-driver/create-driver.component';
import { DriverListComponent } from './driver-list/driver-list.component';
import { DriverDetailsComponent } from './driver-details/driver-details.component';
import { UpdateDriverComponent } from './update-driver/update-driver.component';

@NgModule({
  declarations: [
    AppComponent,
    BusDetailsComponent,
    CreateBusComponent,
    BusListComponent,
    UpdateBusComponent,
    HomeComponent,
    FooterComponent,
    AboutUsComponent,
    ContactUsComponent,
    LoginComponent,
    LogoutComponent,
    FeedbackComponent,
    BookbusComponent,
    UserListComponent,
    SingupComponent,
    AdminComponent,
    UserDetailsComponent,
    CreateDriverComponent,
    DriverListComponent,
    DriverDetailsComponent,
    UpdateDriverComponent
    
  
    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }