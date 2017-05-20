import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class FilmService {

	constructor(private http: Http) { }

	getFilm(title: string){
		let url = "http://www.omdbapi.com/?t=" + title;
		return this.http.get(url).map(
				response => response.json()
			);
	}

	getTitle(title: string){
		let url = "http://www.omdbapi.com/?t=" + title;
		return this.http.get(url).map(response => response.json().Title);
	}

	getYear(title: string){
		let url = "http://www.omdbapi.com/?t=" + title;
		return this.http.get(url).map(response => response.json().Year);
	}

	getPlot(title: string){
		let url = "http://www.omdbapi.com/?t=" + title;
		return this.http.get(url).map(response => response.json().Plot);
	}

	getDirector(title: string){
		let url = "http://www.omdbapi.com/?t=" + title;
		return this.http.get(url).map(response => response.json().Director);
	}

	getActors(title: string){
		let url = "http://www.omdbapi.com/?t=" + title;
		return this.http.get(url).map(response => response.json().Actors);
	}

	getPoster(title: string){
		let url = "http://www.omdbapi.com/?t=" + title;
		return this.http.get(url).map(response => response.json().Poster);
	}

	getimdbRating(title: string){
		let url = "http://www.omdbapi.com/?t=" + title;
		return this.http.get(url).map(response => response.json().imdbRating);
	}

	private extractTitles(response: Response) {
		let out = response.json().items.map(film => film.volumeInfo.title);
		return out;
	}
}