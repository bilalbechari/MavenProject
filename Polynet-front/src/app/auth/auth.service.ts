import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Subject} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  connected: boolean = false

  constructor(private http: HttpClient) {
  }

  isConnected():Boolean{
    return this.connected
  }

  login(username: string, password: string){
    let body = new URLSearchParams();
    body.set('username', username);
    body.set('password', password);

    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded'),
      withCredentials: true
    }

    return this.http.post('http://localhost:8080/login', body.toString(), options).toPromise().then(() => {
      this.connected = true
      console.log("Connecté")
    }, () => {
      this.connected = false
      console.log("Non connecté")
    })
  }
}
