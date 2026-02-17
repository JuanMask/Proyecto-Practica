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
        this.eventos = data.map((e:any) => ({
          ...e,
          asiste: false
        }));
        
      },
      error: (err) => {
        console.error("Error al cargar eventos", err);
      }
    });
  }

  confirmarAsistencia(evento: any){
    const idUsuario = localStorage.getItem("idUsuario");

    if (!idUsuario){
      alert("Usuario no identificado");
      return;
    }

    const dto = {
      idEvento: evento.id_evento,
      idUsuario: Number(idUsuario)
    };

    this.http.post('http://localhost:8080/asistencia/confirmar', dto)
    .subscribe({
      next: () => {
        alert("Asistencia confirmada");
        evento.asiste = true;
      },

      error: (err) => {
        console.error(err);
      }
    });
  }

cambiarAsistencia(evento: any, estado: boolean){

  const idUsuario = localStorage.getItem("idUsuario");

  const dto = {
    idEvento: evento.id_evento,
    idUsuario: Number(idUsuario),
    estado: estado
  };

  this.http.put('http://localhost:8080/asistencia/actualiza', dto)
    .subscribe({
      next: () => {
        evento.asiste = false;
      },
      error: (err) => {
        console.error(err);
      }
    });
}

}
