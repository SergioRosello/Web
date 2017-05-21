import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import 'rxjs/Rx';

@Injectable()
export class FilmService {

	constructor(private http: Http) { }

	getFilm(title: string){
		let url = "http://ec2-34-211-5-120.us-west-2.compute.amazonaws.com/?&t=" + title;
		return this.http.get(url).map(
				response => response.json()
			);
	}
}