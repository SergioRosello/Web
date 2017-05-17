import { Component } from '@angular/core';
// Para el servico REST
import { Http } from '@angular/http';
import { FilmService } from './film.service';
@Component({
	selector: 'app-root',
	templateUrl: './app.component.html'
})
export class AppComponent {

	private result: Array<Object>;
	private Title: string;
	private Year: string;
	private Plot: string;
	private Director: string;
	private Actors: string;
	private Poster: string;
	private imdbRating: string;

	constructor(private filmService: FilmService, private http: Http) { }

	search(title: string) {
		this.filmService.getTitle(title).subscribe(
				films => this.Title = films,
				error => console.error(error)
			);
		
		this.filmService.getYear(title).subscribe(
				films => this.Year = films,
				error => console.error(error)
			);

		this.filmService.getPlot(title).subscribe(
				films => this.Plot = films,
				error => console.error(error)
			);

		this.filmService.getDirector(title).subscribe(
				films => this.Director = films,
				error => console.error(error)
			);

		this.filmService.getActors(title).subscribe(
				films => this.Actors = films,
				error => console.error(error)
			);

		this.filmService.getPoster(title).subscribe(
				films => this.Poster = films,
				error => console.error(error)
			);

		this.filmService.getimdbRating(title).subscribe(
				films => this.imdbRating = films,
				error => console.error(error)
			);
	}



}