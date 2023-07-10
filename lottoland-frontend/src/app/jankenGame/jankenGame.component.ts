import { Component } from '@angular/core';
import { JankenService } from '../janken.service';
import { StatsJankenDTO } from '../stats-janken-dto';
import { StatsService } from '../stats.service';
import { JankenDTO } from '../janken-dto';
import { Subscription, interval } from 'rxjs';

@Component({
  selector: 'app-playjanken',
  templateUrl: './jankenGame.component.html',
  styleUrls: ['./jankenGame.component.css']
})
export class JankenGameComponent {

  statsJanken:StatsJankenDTO;
  intervalSubscription:Subscription;

  constructor(private jankenService:JankenService, private statsService:StatsService){}

  ngOnInit(): void {
    this.statsJanken = new StatsJankenDTO();
    this.getStatsJankenBySession();

    this.intervalSubscription = interval(1000).subscribe(() => {
      this.getStatsJankenBySession();
    });
  }

  ngOnDestroy() {
    if (this.intervalSubscription) {
      this.intervalSubscription.unsubscribe();
    }
  }

  public playJanken(){
    this.jankenService.playJanken().subscribe(response => {
      if(response.player2 == "Rock"){
        this.getStatsJankenBySession();
      }
    })
  }

  public getStatsJankenBySession(){
    this.statsService.getStatsJankenBySession().subscribe(response => {
      this.statsJanken = response;
      this.statsJanken.rounds.sort((a, b) => a.playedAt.localeCompare(b.playedAt));
    })
  }

  public resetSession(){
    this.jankenService.resetSession().subscribe(response => {
      if(response == "OK"){
        this.getStatsJankenBySession();
      }
    })
  }
}
