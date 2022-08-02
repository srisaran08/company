import { Component, OnInit } from '@angular/core';
import { Plant } from '../plant';
import { PlantService } from '../plant.service';
import { ActivatedRoute,Router } from '@angular/router'; 

@Component({
  selector: 'app-update-plant',
  templateUrl: './update-plant.component.html',
  styleUrls: ['./update-plant.component.css']
})
export class UpdatePlantComponent implements OnInit {

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
  updatePlant() {

    this.plantService.updatePlant(this.plantId, this.plant)
      .subscribe(data => {
        console.log(data);
        this.plant = new Plant();
        this.gotoList();
      }, error => console.log(error));
  }
  onSubmit() {
    this.updatePlant();    
  }

  gotoList() {
    this.router.navigate(['/plant']);
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
