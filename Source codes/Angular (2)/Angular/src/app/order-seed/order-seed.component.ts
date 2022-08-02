import { Component, OnInit } from '@angular/core';
import { Seed } from '../seed';
import { Router,ActivatedRoute} from '@angular/router';
import { SeedService } from "../seed.service";

@Component({
  selector: 'app-order-seed',
  templateUrl: './order-seed.component.html',
  styleUrls: ['./order-seed.component.css']
})
export class OrderSeedComponent implements OnInit {
  seed: Seed;
  seedId: number;
 
  constructor(private route: ActivatedRoute,private router: Router,
    private seedService: SeedService) { 
      
    }

  ngOnInit(): void {
    this.seed = new Seed();

    this.seedId = this.route.snapshot.params['seedId'];
    
    this.seedService.getSeed(this.seedId)
      .subscribe(data => {
        console.log(data)
        this.seed = data;
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
