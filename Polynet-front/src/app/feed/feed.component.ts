import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {FeedService} from "../feed.service";
import {Story} from "../Story";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.scss']
})
export class FeedComponent implements OnInit {
  stories: Array<Story>

  constructor(private feedService: FeedService) {
  }

  ngOnInit() {
    this.feedService.fetch().then(() => {
      this.stories = this.feedService.stories
    })
  }
}
