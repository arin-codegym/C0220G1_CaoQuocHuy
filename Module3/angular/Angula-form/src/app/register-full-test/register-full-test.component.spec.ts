import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterFullTestComponent } from './register-full-test.component';

describe('RegisterFullTestComponent', () => {
  let component: RegisterFullTestComponent;
  let fixture: ComponentFixture<RegisterFullTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterFullTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterFullTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
