import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PlantService } from '../plant.service';
import { Plant } from '../plant';

@Component({
  selector: 'app-buy',
  templateUrl: './buy.component.html',
  styleUrls: ['./buy.component.css']
})
export class BuyComponent implements OnInit {

  plantId: number;
  plant: Plant;
  commonname: string;
  plantCost: number;
  constructor(private route: ActivatedRoute,private router: Router,
    private plantService: PlantService) { }

  ngOnInit(): void {
    this.plant= new Plant();
    this.plantId=this.route.snapshot.params['plantId'];
    this.plantService.getPlant(this.plantId)
    .subscribe(data => {
      console.log(data)
      this.plant = data;
    }, error => console.log(error));
  }

  cart(plantId: number)
  {
   
    this.router.navigate(['cart',plantId]);
  }
  go()
  {
   
    this.router.navigate(['home']);
  }
  goToLogin()
  {
   
    this.router.navigate(['login']);
  }
}
