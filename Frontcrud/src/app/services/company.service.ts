import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { URL_SERVICE } from "../config/config";
import { Company } from "../model/Project.model";

@Injectable({
  providedIn: "root",
})
export class CompanyService {
  constructor(private http: HttpClient) {}

  getCompanyAll() {
    let url = URL_SERVICE + "/companys/company";
    return this.http.get(url);
  }

  postCompany(company: Company) {
    let url = URL_SERVICE + "/companys";
    return this.http.post(url, company);
  }

  putProject(company: Company) {
    let url = URL_SERVICE + "/companys" + company.id_company + "/edit";
    return this.http.put(url, company);
  }

  deleteProject(id: number) {
    let url = URL_SERVICE + "/companys" + id + "/delete";
    return this.http.delete(url);
  }
}
