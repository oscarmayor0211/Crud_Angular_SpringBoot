import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";

@Component({
  selector: "app-service",
  templateUrl: "./service.component.html",
  styleUrls: ["./service.component.css"],
})
export class ServiceComponent implements OnInit {
  form: FormGroup;
  constructor(private fb: FormBuilder, private router: Router) {}

  ngOnInit() {}

  crearFormulario() {
    this.form = this.fb.group({
      id_market: [],
      name: ["", Validators.required],
    });
  }

  get NameInvalid() {
    return this.form.get("name").invalid && this.form.get("name").touched;
  }
  createService() {}

  cancel() {
    this.router.navigateByUrl("/projects");
  }
}
