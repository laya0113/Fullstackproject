import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';
import { Flight } from '../flight';
import { ActivatedRoute, Router } from '@angular/router';
@Component({
  selector: 'app-updateflight',
  templateUrl: './updateflight.component.html',
  styleUrls: ['./updateflight.component.css']
})
  export class UpdateflightComponent implements OnInit{
    id: number = 0;
    flight: Flight = new Flight();
    constructor(private flightService: FlightService,
      private route: ActivatedRoute,
      private router: Router) { }
  
    ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];  //1
  
      this.flightService.getFlightById(this.id).subscribe(data => {
        this.flight = data;
      }, error => console.log(error));
    }
  
    onSubmit(){
      this.flightService.updateFlight(this.id, this.flight).subscribe( data =>{
        this.getAllFlightDetails();
      }
      , error => console.log(error));
    }
  
    getAllFlightDetails(){
      this.router.navigate(['/see-all-flights']);
    }
  }

