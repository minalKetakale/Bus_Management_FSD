import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { User } from '../user';

import { ActivatedRoute, Router } from '@angular/router';
import { BusService } from '../bus.service';
import { UserService } from '../user.service';
@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  user: User[]=[];
  pageNo: number = 1;
  count: number = 5;
  busId:number=0;
  userID:number=0;
  
 
  

  constructor(private  UserService: UserService,
    private route: ActivatedRoute,
    private router: Router
   ) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];
    
   
  this.UserService.getUsersByBusId(this.busId).subscribe(data=>{
    console.log(data);
    this.user=data;

  
    });
  }

  


  private getUser(){
    
    this.UserService.getUserList().subscribe(data => {
      this.user = data;

      console.log(data);
      //int num[]
      //int num1[]
      //num = num1
    });
  }

  UserDetails(userID: number){
    
    console.log(userID);
   
    this.router.navigate(['user-details', userID]);
  }


  deleteUser(userID: number){
    var status =  confirm("Are you sure to delete this records?");
    if(status == true){
    console.log(userID)
    this.UserService.deleteUserDetailsById(userID).subscribe( data => {
      console.log(data);
      this.getUser();
    },
      
    error => {
      console.log(error);

    })
  }
  else{
    this.getUser();
  }

  }

}