import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Seed } from './seed';


@Injectable({
  providedIn: 'root'
})
export class SeedService {

  private baseUrl = 'http://localhost:8090/seed';
  private url ='http://localhost:8090/admin';


  constructor(private http: HttpClient) { }
  createSeed(seed: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, seed);
  }
  getSeed(seedId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${seedId}`);
  }
  deleteSeed(seedId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${seedId}`, { responseType: 'text' });
  }

  updateSeed(seedId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${seedId}`, value);
  }

  getSeedList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
