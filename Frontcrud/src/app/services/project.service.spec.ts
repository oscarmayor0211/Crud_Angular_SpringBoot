import { TestBed } from "@angular/core/testing";

import { ProjectService } from "./project.service";
import { HttpClient } from "@angular/common/http";

describe("ProjectService", () => {
  let service: ProjectService;
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        ProjectService,
        {
          provide: HttpClient,
        },
      ],
    });
    service = TestBed.get(ProjectService);
  });

  it("should be created", () => {
    const service: ProjectService = TestBed.get(ProjectService);
    expect(service).toBeTruthy();
  });
});
