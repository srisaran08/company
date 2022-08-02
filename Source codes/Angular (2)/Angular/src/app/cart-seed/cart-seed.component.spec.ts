import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CartSeedComponent } from './cart-seed.component';

describe('CartSeedComponent', () => {
  let component: CartSeedComponent;
  let fixture: ComponentFixture<CartSeedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CartSeedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CartSeedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
