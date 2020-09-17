import { TestBed } from "@angular/core/testing";
import { from, empty } from "rxjs";
import { HttpClient } from "@angular/common/http";
import { ProjectService } from "../../services/project.service";
import { ProjectListComponent } from "./project-list.component";

describe("ProjectList", () => {
  let component: ProjectListComponent;
  let service: ProjectService;
  beforeEach(() => {
    component = new ProjectListComponent(service);
    TestBed.configureTestingModule({
      declarations: [ProjectListComponent, ProjectService], // declare the test component
      imports: [HttpClient],
    });
  });
});
