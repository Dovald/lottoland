import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { GlobalStatsJankenDTO } from './global-stats-janken-dto';
import { Observable } from 'rxjs';
import { StatsJankenDTO } from './stats-janken-dto';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class StatsService {

  private baseURL = "http://localhost:8088/lottoland/stats/janken";
  sessionId: string;

  constructor(private httpClient : HttpClient, private sessionService: SessionService) {
    this.sessionId = sessionService.sessionId;
   }

  getGlobalStats():Observable<GlobalStatsJankenDTO>{
    return this.httpClient.get<GlobalStatsJankenDTO>(`${this.baseURL}`);
  }

  getStatsJankenBySession():Observable<StatsJankenDTO>{
    return this.httpClient.get<StatsJankenDTO>(`${this.baseURL}` + "/" + this.sessionId);
  }
}
