import { Component } from '@angular/core';
import { Router } from "@angular/router";
import { HttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-crear-evento',
  templateUrl: './crear_evento.component.html',
  styleUrls: ['./crear_evento.component.css'],
  imports: [RouterLink, FormsModule, CommonModule]
})
export class CrearEventoComponent {
  nombre: string = '';
  descripcion: string= '';
  fechaEvento: string = '';
  creador: string = '';

  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  crearEvento(){
    const url = 'http://localhost:8080/evento/cEvento';

    const body = {
      nombre: this.nombre,
      descripcion: this.descripcion,
      fechaEvento: this.fechaEvento,
      creador: this.creador
    };

    this.http.post(url, body).subscribe({
      next: () => {
        alert("Evento creado correctamente");
        this.router.navigate(['/principal']);
      },
      error: (err) => {
        alert("Error al crear el evento");
        console.error(err);
      }
    });
  }

}
