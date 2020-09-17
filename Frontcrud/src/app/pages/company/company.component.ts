import { Component, OnInit } from "@angular/core";
import { FormGroup, FormBuilder, Validators } from "@angular/forms";

@Component({
  selector: "app-company",
  templateUrl: "./company.component.html",
  styleUrls: ["./company.component.css"],
})
export class CompanyComponent implements OnInit {
  form: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.crearFormulario();
  }

  crearFormulario() {
    this.form = this.fb.group({
      id_company: [],
      name: ["", Validators.required],
    });
  }

  get NameInvalid() {
    return this.form.get("name").invalid && this.form.get("name").touched;
  }
  createCompany() {}
}
