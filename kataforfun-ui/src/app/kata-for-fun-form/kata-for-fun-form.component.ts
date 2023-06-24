import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {  FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-kata-for-fun-form',
  templateUrl: './kata-for-fun-form.component.html'
})
export class KataForFunFormComponent implements OnInit {


  conversionForm: FormGroup;
  @Output() submitNumberOutput: EventEmitter<number>;


  constructor() {
    this.submitNumberOutput = new EventEmitter<number>();

    this.conversionForm = new FormGroup({
      // make sure a value is always provide, use to control submit button state
      inputNumber : new FormControl(null, Validators.required)
    });

  }

  ngOnInit(): void {

  }


  submitNumber(): void {
   const input = this.conversionForm.value.inputNumber;
   this.submitNumberOutput.emit(input);
  }

}
