import { Routes } from '@angular/router';
/* import { EventosComponent } from './components/eventos/eventos.component'; */
import { EventosComponent } from '../app/components/eventos/eventos.component';
import { Registro } from './registro/registro/registro.component';
import { CrearEventoComponent } from '../app/crear_evento/crear_evento.component';
import { PrincipalComponent } from '../app/principal/principal.component';

export const routes: Routes = [
  { path: '', component: EventosComponent },
  { path: 'registro', component: Registro},
  { path: 'crear_evento', component: CrearEventoComponent },
  { path: 'principal', component: PrincipalComponent }
];


