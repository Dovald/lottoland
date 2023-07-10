import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JankenGameComponent } from './jankenGame.component';

describe('PlayjankenComponent', () => {
  let component: JankenGameComponent;
  let fixture: ComponentFixture<JankenGameComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [JankenGameComponent]
    });
    fixture = TestBed.createComponent(JankenGameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
