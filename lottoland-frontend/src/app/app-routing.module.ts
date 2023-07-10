import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JankenGameComponent } from './jankenGame/jankenGame.component';
import { GlobalStatsComponent } from './globalStats/globalStats.component';

const routes: Routes = [
  {path: 'JankenGame', component:JankenGameComponent},
  {path: '', redirectTo:'JankenGame',pathMatch:'full'},
  {path: 'GlobalStats', component:GlobalStatsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
