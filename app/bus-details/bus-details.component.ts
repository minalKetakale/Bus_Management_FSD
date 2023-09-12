import { Component, OnInit } from '@angular/core';
import { Bus } from '../bus';
import { ActivatedRoute, Router } from '@angular/router';
import { BusService} from '../bus.service';

@Component({
  selector: 'app-bus-details',
  templateUrl: './bus-details.component.html',
  styleUrls: ['./bus-details.component.css']
})
export class BusDetailsComponent implements OnInit {

  busId: number = 0;
  bus: any = [];
  constructor(private route: ActivatedRoute,private router:Router, private busService: BusService) { }

  ngOnInit(): void {
    this.busId = this.route.snapshot.params['busId'];

    this.bus = new Bus();
    console.log(this.busId);
    this.busService.getBusDetailsById(this.busId).subscribe( data => {
      this.bus = data;
    });
  }

   home(){
       this.router.navigate(['bus-details']);
   }


  book(busId:number){
    this.router.navigate(['book-bus',busId]);
  }

  

}