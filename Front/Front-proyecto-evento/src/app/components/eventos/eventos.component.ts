import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { RouterLink } from "@angular/router";
import { FormsModule} from '@angular/forms';

@Component({
  selector: 'app-evento',
  templateUrl: './eventos.component.html',
  styleUrls: ['./eventos.component.css'],
  imports: [RouterLink, FormsModule]
})


export class EventosComponent {
  correo: string='';
  ps: string='';
  mensaje: string='';

  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  login(){
    
    const url = 'http://localhost:8080/usuario/log';

    const body = {
      email: this.correo,
      ps: this.ps
    };

    this.http.post<any>(url, body).subscribe({
      next: (response) => {
        this.router.navigate(['/principal']),
        localStorage.setItem("idUsuario", response.id_usuario);
      },
      error: () => {
        alert('Correo o contraseña incorrectos');
      }
    });
  }


}