import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {StoryPublisherComponent} from './story-publisher.component';

describe('StoryPublisherComponent', () => {
  let component: StoryPublisherComponent;
  let fixture: ComponentFixture<StoryPublisherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [StoryPublisherComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(StoryPublisherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
