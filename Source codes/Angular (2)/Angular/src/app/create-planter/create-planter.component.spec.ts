import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatePlanterComponent } from './create-planter.component';

describe('CreatePlanterComponent', () => {
  let component: CreatePlanterComponent;
  let fixture: ComponentFixture<CreatePlanterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatePlanterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatePlanterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
