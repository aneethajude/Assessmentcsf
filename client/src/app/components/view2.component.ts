import { Component } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Bundle } from '../model/bundle';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceutilsService } from '../services/serviceutils.service';

@Component({
  selector: 'app-view2',
  templateUrl: './view2.component.html',
  styleUrls: ['./view2.component.css']
})
export class View2Component {
  view2Form!: FormGroup;
  bundleList!: Bundle[];
  bundleId: any;
  constructor(private formBuilder: FormBuilder, private locationService: Location, private activatedroute: ActivatedRoute, private router: Router, private serviceUtils: ServiceutilsService) { }

  ngOnInit(): void {
    this.bundleId = this.activatedroute.snapshot.paramMap.get("bundleId");
    this.view2Form = this.formBuilder.group({
      
    });

    this.serviceUtils.getBundleList(this.bundleId).subscribe({
      next: (data: any) => {
        console.log(data);
        this.bundleList = data;
      }, 
      error: err => {
        console.log(err);
      }
    });
  }

  getBack() {
  //  this.locationService.getback();
  }
}
