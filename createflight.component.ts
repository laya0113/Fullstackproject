import { Component, OnInit } from '@angular/core';
import { Flight } from '../flight';
import { Router } from '@angular/router';
import { FlightService } from '../flight.service';

@Component({
  selector: 'app-createflight',
  templateUrl: './createflight.component.html',
  styleUrls: ['./createflight.component.css']
})
  export class CreateflightComponent {
  
    constructor(private flightService: FlightService,
      private router: Router) { }
  
      flights : Flight = new Flight();
      
      
      
      saveFlight(){
        this.flightService.createFlight(this.flights).subscribe( data =>{
          console.log(data);
          this.goToFlightList();
        },
        error => console.log(error));
      }
    
      goToFlightList(){
        this.router.navigate(['/see-all-flights']);
      }
      
      onSubmit(){
        console.log(this.flights);
        this.saveFlight();
      }
  
  
  
  }
