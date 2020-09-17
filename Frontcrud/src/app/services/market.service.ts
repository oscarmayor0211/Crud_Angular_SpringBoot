import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { URL_SERVICE } from "../config/config";
import { Market } from "../model/Project.model";

@Injectable({
  providedIn: "root",
})
export class MarketService {
  constructor(private http: HttpClient) {}

  getMarketAll() {
    let url = URL_SERVICE + "/markets/market";

    return this.http.get(url);
  }

  deleteMarket(id: number) {
    let url = URL_SERVICE + "/markets/" + id + "/delete";
    return this.http.delete(url);
  }

  postMarket(market: Market) {
    let url = URL_SERVICE + "/markets";
    return this.http.post(url, market);
  }

  putMarket(market: Market) {
    let url = URL_SERVICE + "/markets" + market.id_market + "/edit";
    return this.http.put(url, market);
  }
}
