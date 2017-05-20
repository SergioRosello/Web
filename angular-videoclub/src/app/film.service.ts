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
}