import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminGraphicsComponent } from './admin-graphics.component';

describe('AdminGraphicsComponent', () => {
  let component: AdminGraphicsComponent;
  let fixture: ComponentFixture<AdminGraphicsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminGraphicsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminGraphicsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
