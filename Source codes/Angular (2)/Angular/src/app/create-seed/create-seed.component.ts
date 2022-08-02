import { Component, OnInit } from '@angular/core';
import { Seed } from '../seed';
import { SeedService } from '../seed.service';
import  {Router}  from '@angular/router';
@Component({
  selector: 'app-create-seed',
  templateUrl: './create-seed.component.html',
  styleUrls: ['./create-seed.component.css']
})
export class CreateSeedComponent implements OnInit {

  seed: Seed = new Seed();
  submitted = false;

  constructor(private seedService: SeedService,
    private router: Router) { }

  ngOnInit(): void {
  }
  newSeed(): void {
    this.submitted = false;
    this.seed = new Seed();
  }

  save(){
    this.seedService
    .createSeed(this.seed).subscribe(data => {
      console.log(data)
      this.seed= new Seed();
      this.gotoList();
  },
  error => console.log(error));

}
  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/seed']);
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
