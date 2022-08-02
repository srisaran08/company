import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';

@Component({
  selector: 'app-register-customer',
  templateUrl: './register-customer.component.html',
  styleUrls: ['./register-customer.component.css']
})
export class RegisterCustomerComponent implements OnInit {
  customer: Customer = new Customer();
  submitted = false;

  constructor(private customerService: CustomerService,
    private router: Router) { }

  ngOnInit(): void {
  }

  newCustomer(): void {
    this.submitted = false;
    this.customer = new Customer();
  }

  save(){
    this.customerService
    .createCustomer(this.customer).subscribe(data => {
      console.log(data)
      this.customer = new Customer();
      this.gotoList();
  },
  error => console.log(error));

}
  onSubmit() {
    if(this.customer.customerName==null && this.customer.customerEmail==null && this.customer.username==null && this.customer.password==null)
    {
      alert("Fields cannot be empty!");
    }
    else
    {
      this.submitted = true;
      this.save();
    }
        
  }

  gotoList() {
    this.router.navigate(['/login']);
  }

}
