import { Component, OnInit, Input } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { ProjectService } from "../../services/project.service";
import { Project } from "../../model/Project.model";
import Swal from "sweetalert2";
import { CompanyService } from "../../services/company.service";
import { ServiceService } from "../../services/service.service";
import { MarketService } from "../../services/market.service";

@Component({
  selector: "app-project",
  templateUrl: "./project.component.html",
  styleUrls: ["./project.component.css"],
})
export class ProjectComponent implements OnInit {
  forma: FormGroup;
  pro: Project[];
  company: any[] = [];
  market: any[] = [];
  service: any[] = [];
  projec: any;

  constructor(
    private fb: FormBuilder,
    private projectService: ProjectService,
    private companyService: CompanyService,
    private serviceService: ServiceService,
    private marketService: MarketService
  ) {
    this.crearFormulario();
  }

  ngOnInit() {
    this.getProjectAll();
    this.getAllCompany();
    this.getAllMarket();
    this.getAllService();
  }

  crearFormulario() {
    this.forma = this.fb.group({
      id_project: [],
      name: ["", Validators.required],
      description: ["", Validators.required],
      id_company: [null, Validators.required],
      id_service: [null, Validators.required],
      id_market: [null, Validators.required],
    });
  }

  get NameInvalid() {
    return this.forma.get("name").invalid && this.forma.get("name").touched;
  }

  get DescriptionInvalid() {
    return (
      this.forma.get("description").invalid &&
      this.forma.get("description").touched
    );
  }

  get CompanyInvalid() {
    return (
      this.forma.get("id_company").invalid &&
      this.forma.get("id_company").touched
    );
  }
  get ServiceInvalid() {
    return (
      this.forma.get("id_service").invalid &&
      this.forma.get("id_service").touched
    );
  }
  get MarketInvalid() {
    return (
      this.forma.get("id_market").invalid && this.forma.get("id_market").touched
    );
  }

  getAllCompany() {
    this.companyService.getCompanyAll().subscribe((company: any) => {
      console.log(company);
      this.company = company;
    });
  }

  getAllMarket() {
    this.marketService.getMarketAll().subscribe((market: any) => {
      console.log(market);
      this.market = market;
    });
  }

  getAllService() {
    this.serviceService.getServiceAll().subscribe((service: any) => {
      console.log(service);
      this.service = service;
    });
  }

  createProject() {
    console.log(this.forma.value);
    this.projec = {
      id_project: this.forma.value.id_project,
      description: this.forma.value.description,
      name: this.forma.value.name,
      id_company: {
        id_company: this.forma.value.id_company,
      },
      id_market: {
        id_market: this.forma.value.id_market,
      },
      id_service: {
        id_service: this.forma.value.id_service,
      },
    };

    console.log(this.projec);

    if (this.forma.invalid) {
      return Object.values(this.forma.controls).forEach((control) => {
        if (control instanceof FormGroup) {
          Object.values(control.controls).forEach((control) => {
            control.markAllAsTouched();
          });
        } else {
          control.markAllAsTouched();
        }
      });
    } else {
      if (this.forma.value.id_project === null) {
        this.projectService
          .postProject(this.projec)
          .subscribe((project: any) => {
            console.log(project);

            this.pro = [...this.pro, project];
            Swal.fire("Project Creado");
            this.resetFormulario();
          });
      } else {
        this.projectService
          .putProject(this.projec)
          .subscribe((project: any) => {
            this.getProjectAll();

            Swal.fire("Project Editado");
            this.resetFormulario();
          });
      }
    }
  }

  resetFormulario() {
    this.forma.reset({
      name: "",
      description: "",
      id_company: null,
      id_service: null,
      id_market: null,
    });
  }

  getProjectAll() {
    this.projectService.getProjectAll().subscribe((project: any) => {
      this.pro = project;
    });
  }

  handleDeleteProject(id: number) {
    Swal.fire({
      title: "Desear Eliminar el Proyecto?",
      text: "Eliminar el Proyecto",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Eliminar!",
    }).then((borrar) => {
      if (borrar.value) {
        this.projectService.deleteProject(id).subscribe(() => {
          this.getProjectAll();
        });
      }
    });
  }

  handleEditProject(project: Project) {
    console.log(project);
    this.forma.setValue({
      id_project: project.id_project,
      name: project.name,
      description: project.description,
      id_company: project.id_company.id_company,
      id_service: project.id_service.id_service,
      id_market: project.id_market.id_market,
    });
  }
}
