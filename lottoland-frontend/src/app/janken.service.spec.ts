import { TestBed } from '@angular/core/testing';

import { JankenService } from './janken.service';

describe('JankenService', () => {
  let service: JankenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(JankenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
