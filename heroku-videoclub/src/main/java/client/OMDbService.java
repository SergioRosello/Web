package client;

import retrofit.http.GET;
import retrofit.http.Query;
import videoclub.Film;

public interface OMDbService {

	@GET("/")
	Film getFilm(@Query("t") String t);
}
