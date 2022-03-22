import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ValidatorFilterComponent } from './validator-filter.component';

describe('ValidatorFilterComponent', () => {
  let component: ValidatorFilterComponent;
  let fixture: ComponentFixture<ValidatorFilterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ValidatorFilterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ValidatorFilterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
