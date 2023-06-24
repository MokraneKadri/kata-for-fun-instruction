import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { KataForFunService } from '../kata-for-fun.service';
import { Result } from '../model/result';

@Component({
  selector: 'app-kata-for-fun',
  templateUrl: './kata-for-fun.component.html'
})
export class KataForFunComponent implements OnInit, OnDestroy {

  private subscription: Subscription;

  alreadyConverted: NumberConverted[] = [];
  
  constructor(private kataForFunService: KataForFunService) { }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    if (this.subscription) { // unsubscibe upon component Ondestroy hook callback
      this.subscription.unsubscribe();
    }
  }

  convertNumber(inputNumber: number): void {
    this.subscription = this.kataForFunService.convertNumber(inputNumber)
    .subscribe((res: Result) => {
      this.alreadyConverted.push( { numberToConvert : inputNumber, result : res.result });
    }, error => console.error(`Failed to convert ${inputNumber} !`));
  }

}

interface NumberConverted {
  numberToConvert: number;
  result: string;
}
