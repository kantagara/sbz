import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RemediesModalComponent } from './remedies-modal.component';

describe('RemediesModalComponent', () => {
  let component: RemediesModalComponent;
  let fixture: ComponentFixture<RemediesModalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RemediesModalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RemediesModalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
