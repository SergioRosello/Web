import { Component } from '@angular/core';
// Para el servico REST
import { Http } from '@angular/http';
import { FilmService } from './film.service';
@Component({
	selector: 'app-root',
	templateUrl: './app.component.html'
})
export class AppComponent {

	private films: string[] = [];

	constructor(private filmService: FilmService, private http: Http) { }

	search(title: string) {
		this.films = [];
		this.filmService.getFilms(title).subscribe(
				films => this.films = films,
				error => console.error(error)
			);
	}

	list() {
		this.films = this.filmService.getAllFilms();
	}

}