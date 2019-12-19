import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {FeedService} from "../feed.service";

@Component({
  selector: 'app-story-publisher',
  templateUrl: './story-publisher.component.html',
  styleUrls: ['./story-publisher.component.scss']
})
export class StoryPublisherComponent implements OnInit {
  content: string;

  constructor(private feedService: FeedService) {
  }

  ngOnInit() {
  }

  shareStory() {
    this.feedService.share(this.content)
    this.content = null
  }
}
