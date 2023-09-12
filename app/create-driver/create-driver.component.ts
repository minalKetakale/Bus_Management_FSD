import { Component, OnInit } from '@angular/core';

import { DriverService } from '../driver.service';
import { Router } from '@angular/router';
import { Driver } from '../driver';

@Component({
  selector: 'app-create-driver',
  templateUrl: './create-driver.component.html',
  styleUrls: ['./create-driver.component.css']
})
export class CreateDriverComponent implements OnInit{

  driver: Driver = new Driver();
  constructor(private driverService: DriverService,
    private router: Router) { }
  ngOnInit(): void {
   
  }

  saveDriver(){
    this.driverService.saveDriverDetails(this.driver).subscribe( data =>{
      console.log("hello savebus");
      console.log(data);
      this.goToDriverList();
    },
    error => console.log(error));
  }
 

  goToDriverList(){
    this.router.navigate(['driver-list']);
  }
  
  onSubmit(){
    var status = confirm("Are you sure to Add Serive?");
    console.log(this.driver);
    
    this.saveDriver();
  }

}
