import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlanterDetailsComponent } from './planter-details.component';

describe('PlanterDetailsComponent', () => {
  let component: PlanterDetailsComponent;
  let fixture: ComponentFixture<PlanterDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlanterDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlanterDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
