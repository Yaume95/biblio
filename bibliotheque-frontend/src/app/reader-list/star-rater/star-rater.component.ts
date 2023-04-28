import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges } from '@angular/core';

@Component({
  selector: 'app-star-rater',
  templateUrl: './star-rater.component.html',
  styleUrls: ['./star-rater.component.scss'],
})
export class StarRaterComponent {
  @Input() rating: number;
  @Output() rateChanged: EventEmitter<number> = new EventEmitter<number>();

  public showIcon(i: number) {
    if (this.rating >= i + 1) {
      return 'star';
    }
    return 'star_border';
  }


  rate(value: number) {
    this.rating = value;
    this.rateChanged.emit(value);
  }
}
