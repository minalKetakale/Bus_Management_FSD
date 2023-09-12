import { Component, OnInit } from '@angular/core';
import { Driver } from '../driver';
import { DriverService } from '../driver.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-driver-list',
  templateUrl: './driver-list.component.html',
  styleUrls: ['./driver-list.component.css']
})
export class DriverListComponent implements OnInit {

  drivers: Driver[] = [];
  name: string="";
  driverId:number=0;
  age : number = 0;
  driverEmail : string ="";
  idProofNo:string="";

  pageNo: number = 1;
  count: number = 5;
  selectedSearchType: string="";

  constructor(private DriverService: DriverService,
    private router: Router) { }

  ngOnInit(): void {
    this.getDriver();
  }

  private getDriver(){
    console.log("service");
    this.DriverService.getDriverList().subscribe(data => {
      this.drivers = data;

      //int num[]
      //int num1[]
      //num = num1
    })
  }

  driverDetails(driverId: number){
    this.router.navigate(['driver-details', driverId]);
  }

  updateDriver(driverId: number){
    this.router.navigate(['update-driver',driverId]);
  }

  deleteDriver(driverId: number){
    var status =  confirm("Are you sure to delete this records?");
    if(status == true){
    console.log(driverId)
    this.DriverService.deleteDriverById(driverId).subscribe( data => {
      console.log(data);
      this.getDriver();
    },
      
    error => {
      console.log(error);

    })
  }
  else{
    this.getDriver();
  }

  }

  
  


  
  

  

  
  
  
    
        




}
