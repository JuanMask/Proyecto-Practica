import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RouterLink } from "@angular/router";
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css'],
  standalone: true,
  imports: [RouterLink, CommonModule]
})
export class PrincipalComponent implements OnInit {

  eventos: any[] = [];

  constructor(
    private http: HttpClient
  ) {}

  ngOnInit(): void {
    this.cargarEventos();
  }

  cargarEventos(){
    this.http.get<any[]>('http://localhost:8080/evento/listar')
    .subscribe({
      next: (data) => {
        this.eventos = data;
        asiste: false
      },
      error: (err) => {
        console.error("Error al cargar eventos", err);
      }
    });
  }

  confirmarAsistencia(idEvento: number){
    alert("Asistencia confirmada para el evento ID: " + idEvento);
  }

  cambiarAsistencia(evento: any, estado: boolean){

    const dto = {
      idUsuario: 1,
      idEvento: evento.id_evento,
      estado:estado
    };

    this.http.put('http://localhost:8080/asistencia/actualiza', dto)
    .subscribe({
      next: () => {
        evento.asiste = estado;
      },
      error: (err) => {
        console.error("Error actualizando asistencia", err);
      }
    });
  }

}
