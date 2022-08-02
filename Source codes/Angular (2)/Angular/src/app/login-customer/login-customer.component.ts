import { Component, OnInit ,Input } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from "rxjs";
import { CustomerService } from "../customer.service";
@Component({
  selector: 'app-login-customer',
  templateUrl: './login-customer.component.html',
  styleUrls: ['./login-customer.component.css']
})
export class LoginCustomerComponent implements OnInit {
  username : String
  password : String
  login ='customer'
  constructor(private customerService: CustomerService,private router: Router) { }

  ngOnInit(): void {
    
  }

  loginCheck(username:String, password:String)
  {
      if(this.login=='customer')
      {
        this.loginCustomer(username,password);
      }
      else if(this.login=='admin')
      {
        this.loginAdmin(username,password);
      }
  }

  register(){
    this.router.navigate(['register']);
  }

  loginAdmin(username:String,password:String)
  {
    this.customerService.loginAdmin(username,password).subscribe(data =>{console.log(data)
    if(data==1)
      {
        this.router.navigate(['/homeAdmin']);
      }
      else{
        alert("INVALID USER/PASSWORD OF ADMIN");
      }
  
      ;},error=>console.log(error));
  }

  loginCustomer(username:String,password:String)
  {
    this.customerService.loginCustomer(username,password).subscribe(data => {console.log(data)
    if(data==1)
    {
      this.router.navigate(['/home']);
    }
    else{
      alert("INVALID USER/PASSWORD OF CUSTOMER");
    }
    ;},error => console.log(error));
  }
}
