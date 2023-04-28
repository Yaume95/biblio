import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReaderListPageComponent } from './reader-list-page.component';

describe('ReaderListPageComponent', () => {
  let component: ReaderListPageComponent;
  let fixture: ComponentFixture<ReaderListPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReaderListPageComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReaderListPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
