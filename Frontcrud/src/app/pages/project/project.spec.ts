import { TestBed } from "@angular/core/testing";
import { HttpClient } from "@angular/common/http";
import { ProjectService } from "../../services/project.service";
import { ProjectComponent } from "./project.component";
import { FormBuilder, ReactiveFormsModule } from "@angular/forms";
import { from, empty } from "rxjs";

describe("Project", () => {
  let component: ProjectComponent;
  let service: ProjectService;
  beforeEach(() => {
    component = new ProjectComponent(new FormBuilder(), service);
    TestBed.configureTestingModule({
      declarations: [ProjectComponent, ProjectService], // declare the test component
      imports: [ReactiveFormsModule, HttpClient],
    });
  });
  it("se debe de crear el formulario", () => {
    expect(component.forma.contains("id_project")).toBeTruthy();
    expect(component.forma.contains("name")).toBeTruthy();
    expect(component.forma.contains("description")).toBeTruthy();
    expect(component.forma.contains("id_company")).toBeTruthy();
    expect(component.forma.contains("id_market")).toBeTruthy();
    expect(component.forma.contains("id_service")).toBeTruthy();
  });
});
