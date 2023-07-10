import { Component } from '@angular/core';
import { GlobalStatsJankenDTO } from '../global-stats-janken-dto';
import { StatsService } from '../stats.service';
import { Subscription, interval } from 'rxjs';

@Component({
  selector: 'app-globalstats',
  templateUrl: './globalStats.component.html',
  styleUrls: ['./globalStats.component.css']
})
export class GlobalStatsComponent {

  globalStats:GlobalStatsJankenDTO;
  intervalSubscription:Subscription;

  constructor(private statsService:StatsService){}

  ngOnInit(): void {
    this.globalStats = new GlobalStatsJankenDTO();
    this.getGlobalStats();

    this.intervalSubscription = interval(1000).subscribe(() => {
      this.getGlobalStats();
    });
  }

  ngOnDestroy() {
    if (this.intervalSubscription) {
      this.intervalSubscription.unsubscribe();
    }
  }

  private getGlobalStats(){
    this.statsService.getGlobalStats().subscribe(response => {
      this.globalStats = response;
    })
  }

}
