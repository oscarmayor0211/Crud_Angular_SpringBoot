import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { CompanyComponent } from "./pages/company/company.component";
import { ProjectComponent } from "./pages/project/project.component";
import { ServiceComponent } from "./pages/service/service.component";
import { MarketComponent } from "./pages/market/market.component";

const routes: Routes = [
  { path: "projects", component: ProjectComponent },
  { path: "projects/crearcompany", component: CompanyComponent },
  { path: "projects/crearmarket", component: MarketComponent },
  { path: "projects/crearservice", component: ServiceComponent },
  { path: "**", redirectTo: "projects", pathMatch: "full" },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
