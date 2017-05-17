import { Component } from '@angular/core';
import { FilmService } from './film.service';
@Component({
	selector: 'app-root',
	templateUrl: './app.component.html'
})
export class AppComponent {
	private films: string[] = [];
	constructor(private filmService: FilmService) { }
	search(title: string) {
		this.films = this.filmService.getFilm(title);
	}
	list() {
		this.films = this.filmService.getAllFilms();
	}
}