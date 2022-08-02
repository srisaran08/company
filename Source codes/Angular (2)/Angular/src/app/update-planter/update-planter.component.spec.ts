import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePlanterComponent } from './update-planter.component';

describe('UpdatePlanterComponent', () => {
  let component: UpdatePlanterComponent;
  let fixture: ComponentFixture<UpdatePlanterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatePlanterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatePlanterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
