import { Component, EventEmitter, Input, OnInit, Output } from "@angular/core";
import { Project } from "../../model/Project.model";
@Component({
  selector: "app-project-list",
  templateUrl: "./project-list.component.html",
  styleUrls: ["./project-list.component.css"],
})
export class ProjectListComponent implements OnInit {
  @Input() projects: Project;
  @Output() editProject = new EventEmitter<Project>();
  @Output() deletProject = new EventEmitter<number>();
  constructor() {
    console.log(this.projects);
  }

  ngOnInit() {}

  llenarForm(project: Project) {
    console.log(project);
    this.editProject.emit(project);
  }

  deleteProject(id: number) {
    console.log(id);
    this.deletProject.emit(id);
  }
}
