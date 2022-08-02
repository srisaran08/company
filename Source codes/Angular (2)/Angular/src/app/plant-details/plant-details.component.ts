import { Component, OnInit } from '@angular/core';
import { Plant } from '../plant';
import { PlantService } from '../plant.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-plant-details',
  templateUrl: './plant-details.component.html',
  styleUrls: ['./plant-details.component.css']
})
export class PlantDetailsComponent implements OnInit {

  plantId: number;
  plant: Plant;
  

  constructor(private route: ActivatedRoute,private router: Router,
    private plantService: PlantService) { }

  ngOnInit(): void {

    this.plant = new Plant();

    this.plantId = this.route.snapshot.params['plantId'];
    this.plantService.getPlant(this.plantId)
      .subscribe(data => {
        console.log(data)
        this.plant = data;
      }, error => console.log(error));
  }
  list(){
    this.router.navigate(['plant']);
  }
  goToLogin()
  {
   
    this.router.navigate(['login']);
  }
}
