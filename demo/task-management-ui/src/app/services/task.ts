import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  private apiUrl = 'http://localhost:8080/tasks';

  constructor(private http: HttpClient) {}

  getTasks() {
    return this.http.get(`${this.apiUrl}/showTask`);
  }

 addTask(task: any) {
  return this.http.post(`${this.apiUrl}/addTask`, task, { responseType: 'text' });
}

deleteTask(task: any) {
  return this.http.delete(`${this.apiUrl}/deleteTask`, { body: task, responseType: 'text' });
}

updateTask(task: any) {
  return this.http.put(`${this.apiUrl}/updateTask`, task, { responseType: 'text' });
}
}