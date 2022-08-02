import { Component, OnInit } from '@angular/core';
import { Planter } from '../planter';
import { PlanterService } from '../planter.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-planter',
  templateUrl: './create-planter.component.html',
  styleUrls: ['./create-planter.component.css']
})
export class CreatePlanterComponent implements OnInit {
  planter: Planter = new Planter();
  submitted = false;

  constructor(private planterService: PlanterService,
    private router: Router) { }

  ngOnInit(): void {
  }
  newPlanter(): void {
    this.submitted = false;
    this.planter = new Planter();
  }
  save(){
    this.planterService
    .createPlanter(this.planter).subscribe(data => {
      console.log(data)
      this.planter= new Planter();
      this.gotoList();
  },
  error => console.log(error));

}
onSubmit() {
  this.submitted = true;
  this.save();    
}

gotoList() {
  this.router.navigate(['/planter']);
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
