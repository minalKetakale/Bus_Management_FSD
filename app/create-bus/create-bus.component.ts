import { Component, OnInit } from '@angular/core';
import { Bus } from '../bus';
import { BusService } from '../bus.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-bus',
  templateUrl: './create-bus.component.html',
  styleUrls: ['./create-bus.component.css']
})
export class CreateBusComponent implements OnInit {
  
  
  bus: Bus = new Bus();
  constructor(private busService: BusService,
    private router: Router) { }

  ngOnInit(): void {
  }

  saveBus(){
    this.busService.saveBusDetails(this.bus).subscribe( data =>{
      console.log("hello savebus");
      console.log(data);
      this.goToBusList();
    },
    error => console.log(error));
  }

  goToBusList(){
    this.router.navigate(['/bus']);
  }
  
  onSubmit(){
    var status = confirm("Are you sure to Add Serive?");
    console.log(this.bus);
    
    this.saveBus();
  }
}