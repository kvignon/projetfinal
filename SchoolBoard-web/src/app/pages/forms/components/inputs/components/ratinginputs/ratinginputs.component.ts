import { Component } from '@angular/core';

@Component({
  selector: 'appratinginputs',
  templateUrl: './ratinginputs.html'
})

export class Rating {
  public _rate1 = 3;
  public _rate2 = 4;

  public _max1 = 5;
  public _max2 = 10;

  constructor() {
  }

}
