import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../services/user';
import { CommonModule } from '@angular/common';
@Component({
  selector: 'app-login',
  imports: [FormsModule,CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  constructor (private router:Router,private userService:UserService){}
  gmail:string='';
  password:string='';
  errorMes='';
  submitLogin() {
  this.userService.login(this.gmail, this.password).subscribe({
    next: (token) => {
      if (token) {
        localStorage.setItem('token', token as string);
        this.router.navigate(['/tasks']);
      } else {
        this.errorMes = 'Invalid email or password';
      }
    },
    error: (err) => {
      this.errorMes = 'Please try again';
    }
  });
}
}



