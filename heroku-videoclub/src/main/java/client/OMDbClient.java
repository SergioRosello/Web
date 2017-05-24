package client;

import retrofit.RestAdapter;
import videoclub.Film;

public class OMDbClient {

	public static void main(String[] args) {
		RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://www.omdbapi.com").build();
		OMDbService service = adapter.create(OMDbService.class);
		Film result = service.getFilm("Interstellar");
		System.out.println(result.toString());
	}
}
