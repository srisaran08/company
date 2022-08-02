import { Component, OnInit } from '@angular/core';
import { Router,ActivatedRoute} from '@angular/router';
import { Observable } from "rxjs";
import { SeedService } from "../seed.service";
import { Seed } from "../seed";
@Component({
  selector: 'app-cart-seed',
  templateUrl: './cart-seed.component.html',
  styleUrls: ['./cart-seed.component.css']
})
export class CartSeedComponent implements OnInit {

  seed: Seed;
  seedId: number;
 
  constructor(private route: ActivatedRoute,private router: Router,
    private seedService: SeedService) { }

  ngOnInit(): void {
    this.seed = new Seed();

    this.seedId = this.route.snapshot.params['seedId'];
    
    this.seedService.getSeed(this.seedId)
      .subscribe(data => {
        console.log(data)
        this.seed = data;
      }, error => console.log(error));
  }

  orderSeed(seedId: number){
    this.router.navigate(['orderSeed',seedId]);
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
