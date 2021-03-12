import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SaldoCcComponent } from './saldo-cc.component';

describe('SaldoCcComponent', () => {
  let component: SaldoCcComponent;
  let fixture: ComponentFixture<SaldoCcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SaldoCcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SaldoCcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
