import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DiseasesModalComponent } from './diseases-modal.component';

describe('DiseasesModalComponent', () => {
  let component: DiseasesModalComponent;
  let fixture: ComponentFixture<DiseasesModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DiseasesModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DiseasesModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
