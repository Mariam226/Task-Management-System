import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = 'http://localhost:8080/users';

  constructor(private http: HttpClient) {}

  login(gmail: string, password: string) {
    return this.http.post(`${this.apiUrl}/login`, { gmail, password }, { responseType: 'text' });
  }

  signup(gmail: string, password: string) {
    return this.http.post(`${this.apiUrl}/signup`, { gmail, password });
  }
}