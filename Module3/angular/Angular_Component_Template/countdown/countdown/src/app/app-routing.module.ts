import {NgModule} from '@angular/core';
import {Routes, RouterModule, Router, ActivatedRoute, NavigationEnd} from '@angular/router';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';
import { CountdownTimerAliasComponent } from './countdown-timer-alias/countdown-timer-alias.component';
import { CountdownTimerEventComponent } from './countdown-timer-event/countdown-timer-event.component';
import { CountdownTimerEventAliasComponent } from './countdown-timer-event-alias/countdown-timer-event-alias.component';
import { CountdownTimerGetSetComponent } from './countdown-timer-get-set/countdown-timer-get-set.component';
import { CountdownTimerOnchangesComponent } from './countdown-timer-onchanges/countdown-timer-onchanges.component';
const routes: Routes = [
  { path: 'CountdownTimerComponent', component: CountdownTimerComponent , data: {count : 5}},
  { path: 'CountdownTimerAliasComponent', component: CountdownTimerAliasComponent },
  { path: 'CountdownTimerEventComponent', component: CountdownTimerEventComponent },
  { path: 'CountdownTimerEventAliasComponent', component: CountdownTimerEventAliasComponent },
  { path: 'CountdownTimerGetSetComponent', component: CountdownTimerGetSetComponent },
  { path: 'CountdownTimerOnchangesComponent', component: CountdownTimerOnchangesComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

}
