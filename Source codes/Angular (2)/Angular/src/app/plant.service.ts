import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Plant } from './plant';

@Injectable({
  providedIn: 'root'
})
export class PlantService {
  private baseUrl = 'http://localhost:8090/plant';
  private url ='http://localhost:8090/admin';

  constructor(private http: HttpClient) { }
  createPlant(plant: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, plant);
  }
  getPlant(plantId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${plantId}`);
  }
  deletePlant(plantId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${plantId}`, { responseType: 'text' });
  }

  updatePlant(plantId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${plantId}`, value);
  }

  getPlantList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
  
}
