import { Component } from '@angular/core';
import { Platform } from 'ionic-angular';
import { Http } from '@angular/http';
import { FilmService } from './film.service';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';
@Component({
  templateUrl: 'app.html'
})
export class MyApp {
  rootPage:any = HomePage;

  private Title: string;
  private Year: string;
  private Plot: string;
  private Director: string;
  private Actors: string;
  private Poster: string;
  private imdbRating: string;

  constructor(platform: Platform,
    statusBar: StatusBar,
    splashScreen: SplashScreen,
    private filmService: FilmService,
    private http: Http) {
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });
  }

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

