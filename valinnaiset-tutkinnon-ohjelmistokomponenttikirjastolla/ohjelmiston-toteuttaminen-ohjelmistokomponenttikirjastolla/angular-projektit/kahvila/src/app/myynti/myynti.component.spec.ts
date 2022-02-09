import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyyntiComponent } from './myynti.component';

describe('MyyntiComponent', () => {
  let component: MyyntiComponent;
  let fixture: ComponentFixture<MyyntiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyyntiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyyntiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
