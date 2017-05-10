package videoclub;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.annotations.SerializedName;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@SerializedName("Title")
	private String title;

	private String Year;
	private String Director;
	private String Content;
	private String Actors;
	private String Genre;
	private String Poster;
	private String Plot;
	private String imdbRating;
	private Boolean Response;
	private String Error;

	public Film() {
	}

	public Film(String title) {
		this.title = title;
	}

	public String gettitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		this.Year = year;
	}

	public String getDirector() {
		return Director;
	}

	public void setDirector(String director) {
		this.Director = director;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	public String getActors() {
		return Actors;
	}

	public void setActors(String actors) {
		this.Actors = actors;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public String getImdbRating() {
		return imdbRating;
	}

	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}

	public String getTitle() {
		return title;
	}

	public String getPoster() {
		return Poster;
	}

	public void setPoster(String poster) {
		this.Poster = poster;
	}

	public String getPlot() {
		return Plot;
	}

	public void setPlot(String plot) {
		this.Plot = plot;
	}

	public Boolean getResponse() {
		return Response;
	}

	public void setResponse(Boolean response) {
		this.Response = response;
	}

	public String getError() {
		return Error;
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", Year=" + Year + ", Director=" + Director + ", Actors="
				+ Actors + ", Poster=" + Poster + ", Plot=" + Plot + ", imdbRating=" + imdbRating + ", Response="
				+ Response + ", Error=" + Error + "]";
	}

	public void setError(String error) {
		this.Error = error;
	}

}