import { CustomerDetailsComponent } from '../customer-details/customer-details.component';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { CustomerService } from "../customer.service";
import { Customer } from "../customer";
@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Observable<Customer[]>;
  constructor(private customerService: CustomerService,
    private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.customers = this.customerService.getCustomersList();
  }

  deleteCustomer(customerId: number) {
    this.customerService.deleteCustomer(customerId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  updateCustomer(customerId: number){
    this.router.navigate(['update', customerId]);
  }

  customerDetails(customerId: number){
    this.router.navigate(['details', customerId]);
  }

  goToLogin()
  {
   
    this.router.navigate(['login']);
  }
  go()
  {
   
    this.router.navigate(['homeAdmin']);
  }
}
