import { Component, OnInit } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Bundle } from '../model/bundle';
import { ServiceutilsService } from '../services/serviceutils.service';

@Component({
  selector: 'app-view0',
  templateUrl: './view0.component.html',
  styleUrls: ['./view0.component.css']
})
export class View0Component implements OnInit{
  view0Form!: FormGroup;
  bundleList!: Bundle[];
  constructor(private formBuilder: FormBuilder, private router: Router, private serviceUtils: ServiceutilsService) { }

  ngOnInit(): void {
    this.view0Form = this.formBuilder.group({
      
    });

    this.serviceUtils.getAllBundleList().subscribe({
      next: (data: any) => {
        console.log(data);
        this.bundleList = data;
      }, 
      error: err => {
        console.log(err);
      }
    });
  }

  fnUpload() {
    this.router.navigate(['/view1']);
  }

}
