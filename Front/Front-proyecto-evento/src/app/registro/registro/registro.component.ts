import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrl: './registro.css',
  imports: [RouterLink,FormsModule, CommonModule]
})


export class Registro {
  nombre: string ='';
  apellido: string ='';
  email: string ='';
  ps: string ='';

  mensaje: string ='';
  error: string ='';

  constructor(
    private http: HttpClient,
    private router: Router
  ) {}

  registrar(){
    const url = 'http://localhost:8080/usuario/reg';

    const body = {
      nombre: this.nombre,
      apellido: this.apellido,
      email: this.email,
      ps: this.ps
    };

    this.http.post(url, body, { responseType: 'text'}).subscribe({
      next: (res) => {
        alert('Usuario registrado correctamente')
       
        //Redirigir a Login 2 segundos despues
        setTimeout(() => {
          this.router.navigate(['']);
        }, 2000);
      },

      error: (err) => {
       alert('Error al registrar. El correo ya puede existir');
      }

    });
  }

}
