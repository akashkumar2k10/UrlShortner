import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LinkRowBoxComponent } from './link-row-box.component';

describe('LinkRowBoxComponent', () => {
  let component: LinkRowBoxComponent;
  let fixture: ComponentFixture<LinkRowBoxComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LinkRowBoxComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LinkRowBoxComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
