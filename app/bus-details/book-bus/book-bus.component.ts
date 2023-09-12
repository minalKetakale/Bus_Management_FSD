import { Component, OnInit } from '@angular/core';
import { Bus } from '../bus';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService } from '../bus.service';
import { UserService } from '../user.service';
import { User } from '../user';
import { EmailService } from '../email.service';


@Component({
  selector: 'app-bus-details',
  templateUrl: './book-bus.component.html',
  styleUrls: [ './book-bus.component.css']
})
export class BookbusComponent implements OnInit {

  busId: number = 0;
 
  user: User = new User();
  userEmail:string="";
  formattedDate!:string;
  
  bus:Bus=new Bus();
  constructor(private UserService: UserService,private BusService:BusService,private EmailService:EmailService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];
    this.formattedDate = this.getFormattedDate();
console.log(this.busId);
   
    };
  
   /* onSubmit(){
      console.log(this.busId);
      console.log(this.user);
      console.log("booked");
      this.UserService.addBooking(this.busId, this.user).subscribe( data =>{
        this.goToBusList();
      }
      , error => console.log(error));
    }*/
  
    goToBusList(){
      this.router.navigate(['/bus']);
    }
  
  
  home(){
    this.router.navigate(['bus']);
  }


  mailchecking(){
    this.bus = new Bus();
    this.BusService.getBusDetailsById(this.busId).subscribe( data => {
      this.bus = data;
    });
      this.EmailService.checkEmail(this.user.userEmail, this.bus).subscribe(data => {
        console.log(data);
        // this.goToRestaurantList();
      },
      error => console.log(error));
   
  }

  onSubmit(){

    //this.user.userDate = this.formatDate(this.user.userDate);
    this.addBookingUser();
    console.log("add user data to the user table... booking sucesful mail should to gooo");
    console.log(this.user.userEmail);
    if (this.user.userEmail) {
      this.mailchecking();

    } else {
      console.log('userEmail is null, cannot make API request.');
    }
    
  }


  addBookingUser() {
    console.log("hello evryone")
    this.UserService.addBooking(this.user, this.busId).subscribe(data=>{
    console.log(this.busId);
     console.log(data);
    },
    error=>console.log(error));
   }

   private getFormattedDate(): string {
    const currentDate = new Date();
    const year = currentDate.getFullYear();
    const month = String(currentDate.getMonth() + 1).padStart(2, '0');
    const day = String(currentDate.getDate()).padStart(2, '0');
    return `${year}-${month}-${day}`;
  }
   
}