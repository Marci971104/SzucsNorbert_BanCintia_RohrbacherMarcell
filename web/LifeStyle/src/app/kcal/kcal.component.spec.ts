import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KcalComponent } from './kcal.component';

describe('KcalComponent', () => {
  let component: KcalComponent;
  let fixture: ComponentFixture<KcalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KcalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KcalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
