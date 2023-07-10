import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { JankenGameComponent } from './jankenGame/jankenGame.component';
import { GlobalStatsComponent } from './globalStats/globalStats.component';
import { SessionService } from './session.service';

@NgModule({
  declarations: [
    AppComponent,
    JankenGameComponent,
    GlobalStatsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [SessionService],
  bootstrap: [AppComponent]
})
export class AppModule { }
