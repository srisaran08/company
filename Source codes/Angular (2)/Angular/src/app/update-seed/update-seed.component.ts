import { Component, OnInit } from '@angular/core';
import { Seed } from '../seed';
import { SeedService } from '../seed.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-update-seed',
  templateUrl: './update-seed.component.html',
  styleUrls: ['./update-seed.component.css']
})
export class UpdateSeedComponent implements OnInit {
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
  updateSeed() {

    this.seedService.updateSeed(this.seedId, this.seed)
      .subscribe(data => {
        console.log(data);
        this.seed = new Seed();
        this.gotoList();
      }, error => console.log(error));
  }
  onSubmit() {
    this.updateSeed();    
  }

  gotoList() {
    this.router.navigate(['seed']);
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
