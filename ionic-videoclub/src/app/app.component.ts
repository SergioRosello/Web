import { Component } from '@angular/core';
import { Platform } from 'ionic-angular';
// import { Http } from '@angular/http';
import { FilmService } from './film.service';

import { StatusBar } from '@ionic-native/status-bar';
import { SplashScreen } from '@ionic-native/splash-screen';

import { HomePage } from '../pages/home/home';


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
  templateUrl: 'app.html',
  providers: [FilmService]
})
export class MyApp {
  rootPage:any = HomePage;

  private film: Film;

  constructor(platform: Platform,
    statusBar: StatusBar,
    splashScreen: SplashScreen,
    private filmService: FilmService) {
    platform.ready().then(() => {
      // Okay, so the platform is ready and our plugins are available.
      // Here you can do any higher level native things you might need.
      statusBar.styleDefault();
      splashScreen.hide();
    });
  }


  getFilm(title: string){
    this.filmService.getFilm(title).subscribe(
      response => this.film = response,
      error => console.error(error)
      );
  }

}

