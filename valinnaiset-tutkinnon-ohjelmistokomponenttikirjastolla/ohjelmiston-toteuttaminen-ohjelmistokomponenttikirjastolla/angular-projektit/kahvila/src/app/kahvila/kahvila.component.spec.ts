import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KahvilaComponent } from './kahvila.component';

describe('KahvilaComponent', () => {
  let component: KahvilaComponent;
  let fixture: ComponentFixture<KahvilaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KahvilaComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(KahvilaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
