import { NgModule } from '@angular/core';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { HomeComponent } from './home/home.component';
import { BuyComponent } from './buy/buy.component';
import { CartComponent } from './cart/cart.component';
import { AboutComponent } from './about/about.component';
//import { AppComponent } from './app.component';
import { OrderComponent } from './order/order.component';
import { OrderSeedComponent } from './order-seed/order-seed.component';
import { CartSeedComponent } from './cart-seed/cart-seed.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { CreateCustomerComponent } from './create-customer/create-customer.component';
import { BuySeedComponent } from './buy-seed/buy-seed.component';
import { LoginCustomerComponent } from './login-customer/login-customer.component';
import { RegisterCustomerComponent } from './register-customer/register-customer.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { RouterModule, Routes } from '@angular/router';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { SeedListComponent } from './seed-list/seed-list.component';
import { PlantListComponent } from './plant-list/plant-list.component';
import { SeedDetailsComponent } from './seed-details/seed-details.component';
import { PlantDetailsComponent } from './plant-details/plant-details.component';
import { UpdateSeedComponent } from './update-seed/update-seed.component';
import { UpdatePlantComponent } from './update-plant/update-plant.component';
import { CreatePlantComponent } from './create-plant/create-plant.component';
import {CreateSeedComponent}  from './create-seed/create-seed.component';
import { PlanterListComponent } from './planter-list/planter-list.component';
import { PlanterDetailsComponent } from './planter-details/planter-details.component';
import { UpdatePlanterComponent } from './update-planter/update-planter.component';
import { CreatePlanterComponent } from './create-planter/create-planter.component'
const routes: Routes = [
  { path: '', redirectTo: 'customer', pathMatch: 'full' },
  { path: 'customers', component: CustomerListComponent },
  { path: 'login', component: LoginCustomerComponent },
  { path: 'about', component: AboutComponent },
  { path: 'addCustomer', component: CreateCustomerComponent },
  { path: 'home', component: HomeComponent},
  { path: '', component: LoginCustomerComponent },
  { path: 'order/:plantId', component: OrderComponent},
  { path: 'orderSeed/:seedId', component: OrderSeedComponent},
  { path : 'seed',component:SeedListComponent},
  { path : 'plant',component: PlantListComponent},
  { path: 'seed/:seedId', component:SeedDetailsComponent},
  { path: 'plant/:plantId',component:PlantDetailsComponent},
  { path: 'updated/:seedId', component: UpdateSeedComponent },
  { path: 'updation/:plantId', component: UpdatePlantComponent },
  { path : 'created',component:CreatePlantComponent},
  { path: 'creation', component: CreateSeedComponent },
  {path: 'planter',component:PlanterListComponent},
  {path: 'planter/:planterId',component:PlanterDetailsComponent},
  {path: 'updateplanter/:planterId',component:UpdatePlanterComponent},
  {path: 'AddPlanter',component:CreatePlanterComponent},
  { path: 'homeAdmin', component: HomeAdminComponent},
  { path: 'register', component: RegisterCustomerComponent},
  { path: 'update/:customerId', component: UpdateCustomerComponent },
  { path: 'details/:customerId', component: CustomerDetailsComponent },
  { path: 'cartSeed/:seedId', component: CartSeedComponent },
  { path: 'cart/:plantId', component: CartComponent },
  { path: 'buy/:plantId', component: BuyComponent },
  { path: 'buySeed/:seedId', component: BuySeedComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
