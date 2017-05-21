import { Component } from '@angular/core';
// Para el servico REST
import { FilmService } from './film.service';


export class Film {
	private Title: string;
	private Year: number;
	private Plot: string;
	private Director: string;
	private Actors: string;
	private Poster: string;
	private imdbRating: number;
}


@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	providers: [FilmService]
})
export class AppComponent {

	private film: Film;

	constructor(private filmService: FilmService) { }

	getFilm(title: string){
		this.filmService.getFilm(title).subscribe(
			response => this.film = response,
			error => console.error(error)
			);
	}
}