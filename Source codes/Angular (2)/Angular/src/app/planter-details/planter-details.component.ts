import { Component, OnInit } from '@angular/core';
import { PlanterService } from '../planter.service';
import { ActivatedRoute,Router } from '@angular/router';
import { Planter } from '../planter';

@Component({
  selector: 'app-planter-details',
  templateUrl: './planter-details.component.html',
  styleUrls: ['./planter-details.component.css']
})
export class PlanterDetailsComponent implements OnInit {
  planterId: number;
  planter: Planter;

  constructor(private route: ActivatedRoute,private router: Router,private planterService : PlanterService ) { }

  ngOnInit(): void {
    this.planter = new Planter();

    this.planterId = this.route.snapshot.params['planterId'];
    this.planterService.getPlanter(this.planterId)
      .subscribe(data => {
        console.log(data)
        this.planter = data;
      }, error => console.log(error));
  }
  list(){
    this.router.navigate(['planter']);
  }
  goToLogin()
  {
   
    this.router.navigate(['login']);
  }
}
