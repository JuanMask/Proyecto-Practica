import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { EventosComponent } from "./components/eventos/eventos.component";
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, EventosComponent, HttpClientModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Front-proyecto-evento');
}
