import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GoogleBooksSearchComponent } from './google-books-autocompletion.component';

describe('GoogleBooksSearchComponent', () => {
  let component: GoogleBooksSearchComponent;
  let fixture: ComponentFixture<GoogleBooksSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GoogleBooksSearchComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GoogleBooksSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
