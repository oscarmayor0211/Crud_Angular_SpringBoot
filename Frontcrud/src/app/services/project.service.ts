import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { URL_SERVICE } from "../config/config";
import { Project } from "../model/Project.model";

@Injectable({
  providedIn: "root",
})
export class ProjectService {
  project: Project;
  constructor(private http: HttpClient) {}

  getProjectAll() {
    let url = URL_SERVICE;

    return this.http.get(url);
  }

  postProject(project: Project) {
    let url = URL_SERVICE;
    return this.http.post(url, project);
  }

  getAllEmpleadoById(id: number) {
    let url = URL_SERVICE + "/" + id;
    return this.http.get(url);
  }

  putProject(project: Project) {
    let url = URL_SERVICE + "/" + project.id_project + "/edit";
    return this.http.put(url, project);
  }

  deleteProject(id: number) {
    let url = URL_SERVICE + "/" + id + "/delete";
    return this.http.delete(url);
  }
}
