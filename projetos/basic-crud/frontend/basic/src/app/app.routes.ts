import { Routes } from '@angular/router';
import { PersonListComponent } from './features/person/person-list/person-list.component';
import { HomeComponent } from './features/home/home.component';

export const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  {
    path: 'home',
    component: HomeComponent,
  },
  {
    path: 'person',
    component: PersonListComponent,
  },
  { path: '**', redirectTo: 'home' }, // Rota fallback
];
