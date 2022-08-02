import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { Planter } from '../planter';
import { PlanterService } from '../planter.service';

@Component({
  selector: 'app-planter-list',
  templateUrl: './planter-list.component.html',
  styleUrls: ['./planter-list.component.css']
})
export class PlanterListComponent implements OnInit {
  planters:Observable<Planter[]>

  constructor(private planterService:PlanterService, private router : Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.planters = this.planterService.getPlanterList();
  }
  deletePlanter(planterId: number) {
    this.planterService.deletePlanter(planterId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  updatePlanter(planterId: number){
    this.router.navigate(['updateplanter', planterId]);
  }

  planterDetails(planterId: number){
    this.router.navigate(['planter', planterId]);
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
