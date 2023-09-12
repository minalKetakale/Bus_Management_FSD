import { TestBed } from '@angular/core/testing';

import { AuthenticationServiceService } from './authenticaton-service.service';

describe('AuthenticatonServiceService', () => {
  let service: AuthenticationServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthenticationServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
