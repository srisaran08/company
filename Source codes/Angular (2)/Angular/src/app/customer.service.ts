import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from './customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  private baseUrl = 'http://localhost:8090/customer';
  private url ='http://localhost:8090/admin';

  constructor(private http: HttpClient) { }

  createCustomer(customer: Object): Observable<Object> {
    return this.http.post(`${this.baseUrl}`, customer);
  }

  loginAdmin(username: String,password:String): Observable<any> {
    return this.http.get(`${this.url}/${username}/${password}`);
  }
  

  getCustomer(customerId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${customerId}`);
  }
  
  loginCustomer(username: String,password:String): Observable<any> {
    return this.http.get(`${this.baseUrl}/${username}/${password}`);
  }

  deleteCustomer(customerId: number): Observable<any> {
    return this.http.delete(`${this.baseUrl}/${customerId}`, { responseType: 'text' });
  }

  updateCustomer(customerId: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/${customerId}`, value);
  }

  getCustomersList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
