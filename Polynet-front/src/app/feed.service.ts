import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Story} from "./Story";

@Injectable({
  providedIn: 'root'
})
export class FeedService {

  public stories: Array<Story>

  constructor(private http: HttpClient) { }

  share(content: string){
    return this.http.post('http://localhost:8080/stories', content,{withCredentials:true}).toPromise().then((success) => {
      const story = { content }
      // this.stories.unshift(story)
      this.fetch()
    }, (error) => {
      console.log(error)
    })
  }

  fetch():Promise<any>{
    return this.http.get<Story[]>('http://localhost:8080/stories').toPromise().then((success) => {
      this.stories = success
    }, (error) => {
      console.log(error)
    })
  }
}
