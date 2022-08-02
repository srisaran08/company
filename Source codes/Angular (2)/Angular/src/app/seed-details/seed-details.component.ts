import { Component, OnInit } from '@angular/core';
import { Seed } from '../seed';
import { Router,ActivatedRoute } from '@angular/router';
import { SeedService } from '../seed.service';
import { SeedListComponent } from '../seed-list/seed-list.component';

@Component({
  selector: 'app-seed-details',
  templateUrl: './seed-details.component.html',
  styleUrls: ['./seed-details.component.css']
})
export class SeedDetailsComponent implements OnInit {

  seedId: number;
  seed: Seed;

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
  list(){
    this.router.navigate(['seed']);
  }
  goToLogin()
  {
   
    this.router.navigate(['login']);
  }
}
