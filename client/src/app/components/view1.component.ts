import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'app-view1',
  templateUrl: './view1.component.html',
  styleUrls: ['./view1.component.css']
})
export class View1Component implements OnInit {
  postcmtform!:FormGroup

  constructor(){

  }

  ngOnInit(): void {
      
  }
  
  cancel(){

  }

  onSubmit(){
    
  }
}
