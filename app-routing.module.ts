import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FlightlistComponent } from './flightlist/flightlist.component';
import { CreateflightComponent } from './createflight/createflight.component';
import { ViewflightComponent } from './viewflight/viewflight.component';
import {UpdateflightComponent} from'./updateflight/updateflight.component';
import { SignInComponent } from './sign-in/sign-in.component';
import { SignUpComponent } from './sign-up/sign-up.component';
import { AuthGaurdService } from './auth-guard.service';
const routes: Routes = [
  {path: 'see-all-flights', component: FlightlistComponent,canActivate: [AuthGaurdService]},
  {path: 'create-flight', component: CreateflightComponent,canActivate: [AuthGaurdService]},
  {path: '', redirectTo: 'signin', pathMatch: 'full'},
  {path: 'update-flight/:id', component: UpdateflightComponent,canActivate: [AuthGaurdService]},
  {path: 'view-flight-details/:id', component: ViewflightComponent, canActivate: [AuthGaurdService]},
  {path:'signin', component: SignInComponent},
  {path:'signup', component: SignUpComponent},
  {path:'log-out',component: SignUpComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }