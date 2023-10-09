import { Component } from '@angular/core';
import { Flight } from '../flight';
import { FlightService } from '../flight.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-flightlist',
  templateUrl: './flightlist.component.html',
  styleUrls: ['./flightlist.component.css']
})
export class FlightlistComponent {
   flights: Flight[] = [];
    flightName : string = "";
    constructor(private flightService: FlightService,
      private router: Router) { }
    
    viewFlight(id:number){
    this.router.navigate(['view-flight-details',id]);
    
    }
    
    ngOnInit(): void {
      this.getFlights();
    }
    searchByName() : any{
      this.flightService.searchByFlightName(this.flightName).subscribe(details => {
        this.flights= details;
        console.log(details);
      },
        error => {
          console.log(error);
        });
    }
    removeAllFlights() : void{
      var status = confirm("Are you sure to delete all the records?");
      if (status == true) {
        this.flightService.deleteAll().subscribe(details => {
          console.log(details);
          this.getFlights();
        },
          error => {
            console.log(error);
          })
      }
      else{
      this.getFlights();
    }
    }
    getDomesticFlights()  {
      this.flightService.findByNonDomesticFLights().subscribe({
        next: (res) => {
        console.log(res);
        this.flights = res;
      },
      error: (e) => console.error(e)
    });
    }
    
    getDomestic(){
      this.flightService.findByDomesticFLights().subscribe({
        next: (res) => {
        console.log(res);
        this.flights = res;
      },
      error: (e) => console.error(e)
    });
    }
    private getFlights(): any{
      this.flightService.getFlightList().subscribe(data => {
        this.flights = data;
        console.log(data);
      });
    }
    
    flightDetails(id: number){
      this.router.navigate(['flight-details', id]);
    }
    
    updateFlight(id: number){
      this.router.navigate(['update-flight', id]);
    }
    
    deleteFlight(id: number){
      var status = confirm("Are you sure to delete this record?");
      if (status == true) {
      this.flightService.deleteFlight(id).subscribe( data => {
        this.getFlights();
      })
    }
      else{
        this.getFlights();
      }
    }
    getFlightBySorting(option:string){
  
      switch(option){
        case "costlow":
          this.flightService.sortByTicketCost("asc","TicketCost").subscribe(data=>{
            this.flights=data;
            console.log(data);
          },error=>{console.log(error)}
          )
          break;
          case "costHigh":
          this.flightService.sortByTicketCost("desc","bookCost").subscribe(data=>{
            this.flights=data;
            console.log(data)
          },error=>{console.log(error)}
          )
          break;
          case "ratinglow":
            this.flightService.sortByFlightRating("asc","ratingOfBook").subscribe(data=>{
              this.flights=data;
              console.log(data)
            },error=>{console.log(error)}
            )
            break;
            case "ratingHigh":
              this.flightService.sortByFlightRating("desc","ratingOfBook").subscribe(data=>{
                this.flights=data;
                console.log(data)
              },error=>{console.log(error)}
              )
    
      }
    }
    }
    

