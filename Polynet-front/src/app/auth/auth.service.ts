import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  connected = false

  constructor(private http: HttpClient) { }

  isConnected(){
    return this.connected
  }

  login(username: string, password: string){
    let body = new URLSearchParams();
    body.set('username', username);
    body.set('password', password);

    let options = {
      headers: new HttpHeaders().set('Content-Type', 'application/x-www-form-urlencoded')
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
