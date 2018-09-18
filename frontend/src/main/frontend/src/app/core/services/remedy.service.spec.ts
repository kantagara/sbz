import { TestBed, inject } from '@angular/core/testing';

import { RemedyService } from './remedy.service';

describe('RemedyService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RemedyService]
    });
  });

  it('should be created', inject([RemedyService], (service: RemedyService) => {
    expect(service).toBeTruthy();
  }));
});
