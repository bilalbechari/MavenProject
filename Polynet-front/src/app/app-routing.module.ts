import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {StoryPublisherComponent} from './story-publisher/story-publisher.component';
import {FeedComponent} from './feed/feed.component';
import {LoginComponent} from "./login/login.component";
import {WallComponent} from "./wall/wall.component";
import {AuthGuard} from "./auth/auth.guard";

const routes: Routes = [
  { path: 'story-publisher', component: StoryPublisherComponent, canActivate: [AuthGuard] },
  { path: 'feed', component: FeedComponent, canActivate: [AuthGuard] },
  { path: 'login', component: LoginComponent },
  { path: '', component: WallComponent, canActivate: [AuthGuard] }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
