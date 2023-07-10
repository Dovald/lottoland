import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { JankenDTO } from './janken-dto';
import { SessionService } from './session.service';

@Injectable({
  providedIn: 'root'
})
export class JankenService {

  private baseURL = "http://localhost:8088/lottoland/janken";
  sessionId: string;

  headers = new HttpHeaders({ 'Content-Type': 'application/json' }); // Puedes ajustar los encabezados según tus necesidades
  options = { headers: this.headers, responseType: 'text' as 'json' };

  constructor(private httpClient : HttpClient, private sessionService: SessionService) {
    this.sessionId = sessionService.sessionId;
   }

  playJanken():Observable<JankenDTO>{
    return this.httpClient.post<JankenDTO>(`${this.baseURL}` + "/" + this.sessionId, null);
  }

  resetSession():Observable<string>{
    return this.httpClient.post<string>(`${this.baseURL}` + "/reset/" + this.sessionId, null, this.options);
  }
}
