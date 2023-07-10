import { ComponentFixture, TestBed } from '@angular/core/testing';
import { GlobalStatsComponent } from './globalStats.component';

describe('GlobalstatsjankenComponent', () => {
  let component: GlobalStatsComponent;
  let fixture: ComponentFixture<GlobalStatsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [GlobalStatsComponent]
    });
    fixture = TestBed.createComponent(GlobalStatsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
