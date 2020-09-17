import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { MarketService } from "../../services/market.service";
import { Market } from "../../model/Project.model";
import Swal from "sweetalert2";

@Component({
  selector: "app-market",
  templateUrl: "./market.component.html",
  styleUrls: ["./market.component.css"],
})
export class MarketComponent implements OnInit {
  form: FormGroup;
  market: Market[];
  constructor(
    private fb: FormBuilder,
    private router: Router,
    private marketService: MarketService
  ) {}

  ngOnInit() {
    this.crearFormulario();
    this.getMarketAll();
  }

  crearFormulario() {
    this.form = this.fb.group({
      id_market: [],
      name: ["", Validators.required],
    });
  }

  get NameInvalid() {
    return this.form.get("name").invalid && this.form.get("name").touched;
  }

  getMarketAll() {
    this.marketService.getMarketAll().subscribe((market: any) => {
      this.market = market;
      console.log(this.market);
    });
  }

  createMarket() {
    if (this.form.value.id_market === null) {
      this.marketService
        .postMarket(this.form.value)
        .subscribe((market: any) => {
          console.log(market);

          this.market = [...this.market, market];
          Swal.fire("Project Creado");
          this.resetFormulario();
        });
    } else {
      this.marketService
        .putMarket(this.form.value)
        .subscribe((project: any) => {
          this.getMarketAll();

          Swal.fire("Market Editado");
          this.resetFormulario();
        });
    }
  }

  resetFormulario() {
    this.form.reset({
      name: "",
    });
  }
  handleDeleteMarkt(id: number) {
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
        this.marketService.deleteMarket(id).subscribe(() => {
          this.getMarketAll();
        });
      }
    });
  }

  handleEditMarkt(markt: Market) {
    console.log(markt);

    this.form.setValue({
      id_project: markt.id_market,
      name: markt.name,
    });
  }

  cancel() {
    this.router.navigateByUrl("/projects");
  }
}
