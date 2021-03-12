import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EstrattoContoCcComponent } from './estratto-conto-cc.component';

describe('EstrattoContoCcComponent', () => {
  let component: EstrattoContoCcComponent;
  let fixture: ComponentFixture<EstrattoContoCcComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EstrattoContoCcComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EstrattoContoCcComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
