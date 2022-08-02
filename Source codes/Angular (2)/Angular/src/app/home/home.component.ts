import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { PlantService } from '../plant.service';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  plantId: number;
  seedId: number;

  constructor(private route: ActivatedRoute,private router: Router,
    private plantService: PlantService) { }

  ngOnInit(): void {
   
  }
 
 
  buyPlant(plantId: number)
  {
    
    this.router.navigate(['buy',plantId]);
  }

  buySeed(seedId: number)
  {
    
    this.router.navigate(['buySeed',seedId]);
  }
  goToLogin()
  {
   
    this.router.navigate(['login']);
  }

}
