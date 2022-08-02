import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OrderSeedComponent } from './order-seed.component';

describe('OrderSeedComponent', () => {
  let component: OrderSeedComponent;
  let fixture: ComponentFixture<OrderSeedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OrderSeedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OrderSeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
