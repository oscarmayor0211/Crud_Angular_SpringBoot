import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { ProjectComponent } from "./pages/project/project.component";
import { ProjectListComponent } from "./pages/project-list/project-list.component";
import { ReactiveFormsModule } from "@angular/forms";
import { HttpClientModule } from "@angular/common/http";
import { CompanyComponent } from './pages/company/company.component';
import { ServiceComponent } from './pages/service/service.component';
import { MarketComponent } from './pages/market/market.component';
import { CompanyListComponent } from './pages/company-list/company-list.component';
import { MarketListComponent } from './pages/market-list/market-list.component';
import { ServiceListComponent } from './pages/service-list/service-list.component';

@NgModule({
  declarations: [AppComponent, ProjectComponent, ProjectListComponent, CompanyComponent, ServiceComponent, MarketComponent, CompanyListComponent, MarketListComponent, ServiceListComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
