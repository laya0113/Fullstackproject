import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FlightlistComponent } from './flightlist/flightlist.component';
import { CreateflightComponent } from './createflight/createflight.component';
import { UpdateflightComponent } from './updateflight/updateflight.component';
import { ViewflightComponent } from './viewflight/viewflight.component';
//import { FlightComponent } from './flight.component';
import {FormsModule} from '@angular/forms';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';

@NgModule({
  declarations: [
    AppComponent,
    FlightlistComponent,
    CreateflightComponent,
    UpdateflightComponent,
    ViewflightComponent,
    SignInComponent,
    SignUpComponent,
    //FlightComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
   // NgxPaginationModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }