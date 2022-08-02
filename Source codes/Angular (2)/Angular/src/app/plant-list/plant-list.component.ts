import { Component, OnInit } from '@angular/core';
import { Plant } from '../plant';
import { Observable } from 'rxjs';
import { Router } from '@angular/router';
import { PlantService } from '../plant.service';

@Component({
  selector: 'app-plant-list',
  templateUrl: './plant-list.component.html',
  styleUrls: ['./plant-list.component.css']
})
export class PlantListComponent implements OnInit {
 plants:Observable<Plant[]>

  constructor(private plantService:PlantService, private router : Router) { }

  ngOnInit(): void {
    this.reloadData();
  }
  reloadData() {
    this.plants = this.plantService.getPlantList();
  }

  deletePlant(plantId: number) {
    this.plantService.deletePlant(plantId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  updatePlant(plantId: number){
    this.router.navigate(['updation', plantId]);
  }

  plantDetails(plantId: number){
    this.router.navigate(['plant', plantId]);
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
