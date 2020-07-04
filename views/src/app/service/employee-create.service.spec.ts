import { TestBed } from '@angular/core/testing';

import { EmployeeCreateService } from './employee-create.service';

describe('EmployeeCreateService', () => {
  let service: EmployeeCreateService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EmployeeCreateService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
