
import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import { PlantService } from "../plant.service";
import { Plant } from "../plant";
@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']

})

export class OrderComponent implements OnInit {
  plant: Plant;
  plantId: number;
 
  constructor(private route: ActivatedRoute,private router: Router,
    private plantService: PlantService) { 
      
    }

  ngOnInit(): void {
    this.plant = new Plant();

    this.plantId = this.route.snapshot.params['plantId'];
    
    this.plantService.getPlant(this.plantId)
      .subscribe(data => {
        console.log(data)
        this.plant = data;
      }, error => console.log(error));
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
