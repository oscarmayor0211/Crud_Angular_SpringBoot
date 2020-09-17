import { Component, OnInit, Input, Output, EventEmitter } from "@angular/core";
import { Market } from "../../model/Project.model";

@Component({
  selector: "app-market-list",
  templateUrl: "./market-list.component.html",
  styleUrls: ["./market-list.component.css"],
})
export class MarketListComponent implements OnInit {
  @Input() markets: Market;
  @Output() deleteMarket = new EventEmitter<number>();
  @Output() editMarket = new EventEmitter<Market>();
  constructor() {}

  ngOnInit() {}

  llenarForm(market: Market) {
    console.log(market);

    this.editMarket.emit(market);
  }

  deleteMarkt(id: number) {
    this.deleteMarket.emit(id);
  }
}
