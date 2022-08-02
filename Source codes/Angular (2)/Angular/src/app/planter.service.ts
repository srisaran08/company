import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Planter } from './planter';

@Injectable({
  providedIn: 'root'
})
export class PlanterService {
  private baseUrl = 'http://localhost:8090/planter';
  private url ='http://localhost:8090/admin';

  constructor(private http: HttpClient) { }
  createPlanter(planter: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, planter);
  }
  getPlanter(planterId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${planterId}`);
  }
  deletePlanter(planterId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${planterId}`, { responseType: 'text' });
  }

  updatePlanter(planterId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${planterId}`, value);
  }

  getPlanterList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
