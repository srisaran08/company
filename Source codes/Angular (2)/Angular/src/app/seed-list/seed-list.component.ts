import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Seed } from '../seed';
import { SeedService } from '../seed.service';

@Component({
  selector: 'app-seed-list',
  templateUrl: './seed-list.component.html',
  styleUrls: ['./seed-list.component.css']
})
export class SeedListComponent implements OnInit {
  seeds:Observable<Seed[]>
  constructor(private seedService:SeedService, private router : Router) { }

  ngOnInit(): void {

    this.reloadData();
  }
  reloadData() {
    this.seeds = this.seedService.getSeedList();
  }

  deleteSeed(seedId: number) {
    this.seedService.deleteSeed(seedId)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  updateSeed(seedId: number){
    this.router.navigate(['updated', seedId]);
  }

  seedDetails(seedId: number){
    this.router.navigate(['seed', seedId]);
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
