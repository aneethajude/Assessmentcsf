import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Observer } from 'rxjs';
import { ServiceutilsService } from '../services/serviceutils.service';

@Component({
  selector: 'app-view1',
  templateUrl: './view1.component.html',
  styleUrls: ['./view1.component.css']
})
export class View1Component implements OnInit {
  view1Form!: FormGroup;
  txtName = "";
  txtTitle = "";
  txtComments = "";
  txtArchive = "";

  constructor(private formBuilder: FormBuilder, private router: Router, private serviceUtils: ServiceutilsService){

  }

  ngOnInit(): void {
    this.view1Form = this.formBuilder.group({
      txtName: new FormControl(), 
      txtTitle: new FormControl(), 
      txtComments: new FormControl(),
      fileArchive: new FormControl(),
      fileSource: new FormControl()
    });
  }

  onFileChange(event:any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.view1Form.patchValue({
        fileSource: file
      });
    }
  }

  onUpload() {
    const formData = new FormData();
    formData.append('name', this.view1Form.get('txtName')?.value);
    formData.append('title', this.view1Form.get('txtTitle')?.value);
    formData.append('comment', this.view1Form.get('txtComments')?.value);
    formData.append('file', this.view1Form.get('fileSource')?.value);
    this.serviceUtils.upload(formData).subscribe({
      next: (data: any) => {
        alert("Uploaded successfully.");
        this.router.navigate(['/view2', data.body.bundledId]);
      }, 
      error: err => {
        console.log(err);
      }
    });
  }

}


