import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AssociaCcComponent } from './associa-cc.component';

describe('AssociaCcComponent', () => {
  let component: AssociaCcComponent;
  let fixture: ComponentFixture<AssociaCcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AssociaCcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AssociaCcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
