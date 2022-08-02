import { Component, OnInit } from '@angular/core';
import { Seed } from '../seed';
import { Router, ActivatedRoute } from '@angular/router';
import { SeedService } from '../seed.service';

@Component({
  selector: 'app-buy-seed',
  templateUrl: './buy-seed.component.html',
  styleUrls: ['./buy-seed.component.css']
})
export class BuySeedComponent implements OnInit {
  seedId: number;
  seed: Seed;
  constructor(private route: ActivatedRoute,private router: Router,
    private seedService: SeedService) { }

  ngOnInit(): void {
    this.seed= new Seed();
    this.seedId=this.route.snapshot.params['seedId'];
    this.seedService.getSeed(this.seedId)
    .subscribe(data => {
      console.log(data)
      this.seed = data;
    }, error => console.log(error));
  }
  cartSeed(seedId: number)
  {
   
    this.router.navigate(['cartSeed',seedId]);
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
