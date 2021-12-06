import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DangerComponent } from './danger.component';

describe('DangerComponent', () => {
  let component: DangerComponent;
  let fixture: ComponentFixture<DangerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DangerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DangerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
