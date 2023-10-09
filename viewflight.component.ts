import { Component, OnInit } from '@angular/core';
import { FlightService } from '../flight.service';
import { ActivatedRoute } from '@angular/router';
import { Flight } from '../flight';

@Component({
  selector: 'app-viewflight',
  templateUrl: './viewflight.component.html',
  styleUrls: ['./viewflight.component.css']
})

  export class ViewflightComponent implements OnInit{
  
    id : number = 0;
    particularFlight: Flight = new Flight();
    constructor(private route: ActivatedRoute, private flightService: FlightService) { }
  
    ngOnInit(): void {
    
      this.id = this.route.snapshot.params['id'];  
  
      this.flightService.getFlightById(this.id).subscribe( data => {
        this.particularFlight = data;
        console.log( this.particularFlight);
      });
    }
  
  }