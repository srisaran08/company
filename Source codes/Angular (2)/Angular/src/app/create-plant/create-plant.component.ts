import { Component, OnInit } from '@angular/core';
import { Plant } from '../plant';
import { PlantService } from '../plant.service'; 
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-create-plant',
  templateUrl: './create-plant.component.html',
  styleUrls: ['./create-plant.component.css']
})
export class CreatePlantComponent implements OnInit {

  plant: Plant = new Plant();
  submitted = false;


  constructor(private plantService: PlantService,
    private router: Router) { }

  ngOnInit(): void {
  }
  newPlant(): void {
    this.submitted = false;
    this.plant = new Plant();
  }
  save(){
    this.plantService
    .createPlant(this.plant).subscribe(data => {
      console.log(data)
      this.plant= new Plant();
      this.gotoList();
  },
  error => console.log(error));

}
onSubmit() {
  this.submitted = true;
  this.save();    
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
