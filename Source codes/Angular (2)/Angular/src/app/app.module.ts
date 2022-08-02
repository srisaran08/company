import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { UpdateCustomerComponent } from './update-customer/update-customer.component';
import { CustomerDetailsComponent } from './customer-details/customer-details.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { LoginCustomerComponent } from './login-customer/login-customer.component';
import { RegisterCustomerComponent } from './register-customer/register-customer.component';
import { HomeComponent } from './home/home.component';
import { BuyComponent } from './buy/buy.component';
import { BuySeedComponent } from './buy-seed/buy-seed.component';
import { CartComponent } from './cart/cart.component';
import { OrderComponent } from './order/order.component';
import { CartSeedComponent } from './cart-seed/cart-seed.component';
import { OrderSeedComponent } from './order-seed/order-seed.component';
import { AboutComponent } from './about/about.component';
import { HomeAdminComponent } from './home-admin/home-admin.component';
import { SeedListComponent } from './seed-list/seed-list.component';
import { PlantListComponent } from './plant-list/plant-list.component'; 
import { SeedDetailsComponent } from './seed-details/seed-details.component'; 
import { PlantDetailsComponent } from './plant-details/plant-details.component';
import { UpdateSeedComponent } from './update-seed/update-seed.component';
import { UpdatePlantComponent } from './update-plant/update-plant.component';
import { CreatePlantComponent } from './create-plant/create-plant.component';
import {CreateSeedComponent}  from './create-seed/create-seed.component';
import {CreateCustomerComponent}  from './create-customer/create-customer.component';
import { PlanterListComponent } from './planter-list/planter-list.component';
import { PlanterDetailsComponent } from './planter-details/planter-details.component';
import { UpdatePlanterComponent } from './update-planter/update-planter.component';
import { CreatePlanterComponent } from './create-planter/create-planter.component';

@NgModule({
  declarations: [
    AppComponent,
    SeedListComponent,
    PlantDetailsComponent,
    CreateSeedComponent,
    CreateCustomerComponent,
    CreatePlantComponent,
    UpdatePlantComponent,
    UpdateSeedComponent,
    PlantListComponent,
    SeedDetailsComponent,
    CustomerListComponent,
    UpdateCustomerComponent,
    CustomerDetailsComponent,
    LoginCustomerComponent,
    RegisterCustomerComponent,
    HomeComponent,
    BuyComponent,
    BuySeedComponent,
    CartComponent,
    OrderComponent,
    CartSeedComponent,
    OrderSeedComponent,
    AboutComponent,
    HomeAdminComponent,
    PlanterListComponent,
    PlanterDetailsComponent,
    UpdatePlanterComponent,
    CreatePlanterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
