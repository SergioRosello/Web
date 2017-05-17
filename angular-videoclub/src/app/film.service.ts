import { Injectable } from '@angular/core';

@Injectable()
export class FilmService {

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

	getAllFilms() {
		return this.myFilms;
	}
}