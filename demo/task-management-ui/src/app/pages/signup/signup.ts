import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserService } from '../../services/user';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-signup',
  imports: [FormsModule,CommonModule],
  templateUrl: './signup.html',
  styleUrl: './signup.css',
})
export class Signup {
  gmail: string = '';
  password: string = '';
  errorMes: string = '';

  constructor(private router: Router, private userService: UserService) {}

  submitSignup() {
    this.userService.signup(this.gmail, this.password).subscribe({
      next: () => {
        this.router.navigate(['/login']);
      },
      error: (err) => {
        this.errorMes= 'Signup failed';
      }
    });
  }
}