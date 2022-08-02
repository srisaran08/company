import { Component, OnInit } from '@angular/core';
import { Planter } from '../planter';
import { PlanterService } from '../planter.service';
import { ActivatedRoute,Router } from '@angular/router';
@Component({
  selector: 'app-update-planter',
  templateUrl: './update-planter.component.html',
  styleUrls: ['./update-planter.component.css']
})
export class UpdatePlanterComponent implements OnInit {
  planterId: number;
   planter: Planter;


  constructor(private route: ActivatedRoute,private router: Router,
    private planterService: PlanterService) { }

  ngOnInit(): void {
    this.planter = new Planter();

    this.planterId = this.route.snapshot.params['planterId'];
    
    this.planterService.getPlanter(this.planterId)
      .subscribe(data => {
        console.log(data)
        this.planter = data;
      }, error => console.log(error));
  }
  updatePlanter() {

    this.planterService.updatePlanter(this.planterId, this.planter)
      .subscribe(data => {
        console.log(data);
        this.planter = new Planter();
        this.gotoList();
      }, error => console.log(error));
  }
  onSubmit() {
    this.updatePlanter();    
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
