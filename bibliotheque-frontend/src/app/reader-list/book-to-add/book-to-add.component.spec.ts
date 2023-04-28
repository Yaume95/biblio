import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookToAddComponent } from './book-to-add.component';

describe('BookToAddComponent', () => {
  let component: BookToAddComponent;
  let fixture: ComponentFixture<BookToAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookToAddComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BookToAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
