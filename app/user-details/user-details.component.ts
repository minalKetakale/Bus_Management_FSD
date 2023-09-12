import { Component } from '@angular/core';
import { Bus } from '../bus';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService } from '../bus.service';
import { UserService } from '../user.service';
import { User } from '../user';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css']
})
export class UserDetailsComponent {

  busId: number = 0;
  bus: any = [];
  userID:number=0;
  user:any=[];
  constructor(private route: ActivatedRoute,private router:Router, private busService: BusService,private userService:UserService) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];
    this.userID = this.route.snapshot.params['userID'];

    this.bus = new Bus();
    
    this.busService.getBusDetailsById(this.busId).subscribe( data => {
      this.bus = data;
    });
    console.log(this.userID)
    this.userService.getUserDetailsById(this.userID).subscribe( data => {
      this.user = data;
    });
  }

   home(){
       this.router.navigate(['bus-list']);
   }


 


}
