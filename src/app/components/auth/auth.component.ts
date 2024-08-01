import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserService } from '../../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-auth',
  standalone: true,
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
  imports: [ReactiveFormsModule]
})
export class AuthComponent {
  loginForm: FormGroup;
  registerForm: FormGroup;

  constructor(private userService: UserService, private fb: FormBuilder, private router: Router) {
    this.loginForm = this.fb.group({
      username: ['', Validators.required],
      password: ['', Validators.required]
    });

    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  login() {
    if (this.loginForm.valid) {
      this.userService.login(this.loginForm.value).subscribe(
        response => {
          const token = response.token;
          const userRole = this.parseToken(token).role;
          if (userRole === 'ADMIN') {
            this.router.navigate(['/admin-dashboard']);
          } else if (userRole === 'USER') {
            this.router.navigate(['/dashboard']);
          }
        },
        error => console.error('Login failed', error)
      );
    }
  }

  register() {
    if (this.registerForm.valid) {
      this.userService.register(this.registerForm.value).subscribe(
        response => console.log('Registration successful', response),
        error => console.error('Registration failed', error)
      );
    }
  }

  private parseToken(token: string) {
    const payload = atob(token.split('.')[1]);
    return JSON.parse(payload);
  }
}
