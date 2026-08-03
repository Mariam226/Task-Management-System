import { Routes } from '@angular/router';
import { Welcome } from './pages/welcome/welcome';
import { Login } from './pages/login/login';
import { Tasks } from './pages/tasks/tasks';
import { Signup } from './pages/signup/signup';
export const routes: Routes = [
{path:'',component:Welcome},
{path:'login',component:Login},
{path:'tasks',component:Tasks},
{path:'signup',component:Signup},
];
