import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class FilmService {

	constructor(private http: Http) { }

	private myFilms: string[] = ['Spring in Action', 'Java for Web Applications', 'Spring Boot Cookbook'];

	getFilm(key: string) {
		let out: string[] = [];
		for (let film of this.myFilms) {
			if (film.includes(key)) {
				out.push(film);
			}
		}
		return out;
	}

	getFilms(title: string){
		let url = "https://www.googleapis.com/books/v1/volumes?q=intitle:" + title;
		return this.http.get(url).map(response => this.extractTitles(response))

	}

	getAllFilms() {
		return this.myFilms;
	}

	private extractTitles(response: Response) {
		let out = response.json().items.map(film => film.volumeInfo.title);
		return out;
	}
}