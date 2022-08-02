import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuySeedComponent } from './buy-seed.component';

describe('BuySeedComponent', () => {
  let component: BuySeedComponent;
  let fixture: ComponentFixture<BuySeedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BuySeedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BuySeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
