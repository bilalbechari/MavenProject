import {Component, OnInit} from '@angular/core';
import {FeedService} from "../feed.service";
import {LoginComponent} from "../login/login.component";
import {AuthService} from "../auth/auth.service";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  connected: boolean

  constructor(private authService: AuthService) {
  }

  ngOnInit() {
 // /   this.connected = this.authService.isConnected()
  }

}
