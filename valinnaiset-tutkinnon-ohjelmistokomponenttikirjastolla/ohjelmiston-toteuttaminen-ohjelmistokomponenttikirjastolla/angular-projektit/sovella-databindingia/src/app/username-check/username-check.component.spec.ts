import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsernameCheckComponent } from './username-check.component';

describe('UsernameCheckComponent', () => {
  let component: UsernameCheckComponent;
  let fixture: ComponentFixture<UsernameCheckComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsernameCheckComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsernameCheckComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
