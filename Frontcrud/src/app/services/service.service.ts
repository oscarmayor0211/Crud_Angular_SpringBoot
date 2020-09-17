import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { URL_SERVICE } from "../config/config";

@Injectable({
  providedIn: "root",
})
export class ServiceService {
  constructor(private http: HttpClient) {}

  getServiceAll() {
    let url = URL_SERVICE + "/services/service";

    return this.http.get(url);
  }
}
