package videoclub;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import client.OMDbService;
import retrofit.RestAdapter;
import retrofit.client.Response;

//http://jvmhub.com/2015/08/09/spring-boot-with-thymeleaf-tutorial-part-3-spring-data-jpa/
@Controller
public class FormController {

	@Autowired
	private FilmRepository filmRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	//TODO: Logout al parecer, no funciona...
	@RequestMapping("/")
	public ModelAndView processLogin() {
        return new ModelAndView("login");
	}
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/home")
	public ModelAndView processHome(Model model) {
		model.addAttribute("anuncios", filmRepo.findAll());
		return new ModelAndView("home");
	}
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/search")
	public ModelAndView processSearch(Model model, @RequestParam(value = "title", required=false) String title) {
		if (title == null || title == ""){
			Iterable<Film> films = filmRepo.findAll();
			return new ModelAndView("search").addObject("films", films);
		}
		Film films = filmRepo.findByTitle(title);
		
		model.addAttribute("films", films);
		return new ModelAndView("search");
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/purchase")
	public ModelAndView processPurchase(Model model,
			@RequestParam(value = "title", required=false) String title,
			@RequestParam(value = "content", required=false) String content,
			@RequestParam(value = "plot", required=false) String plot,
			@RequestParam(value = "year", required=false) String year,
			@RequestParam(value = "director", required=false) String director,
			@RequestParam(value = "genre", required=false) String genre,
			@RequestParam(value = "actors", required=false) String actors,
			@RequestParam(value = "poster", required=false) String poster,
			@RequestParam(value = "imdbRating", required=false) String imdbRating) {
		if (title == null){
			return new ModelAndView("purchase");
		}
		//Llamada al servicio REST (OMBd)
		RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://www.omdbapi.com").build();
		OMDbService service = adapter.create(OMDbService.class);
		Film result = service.getFilm(title);
		Film film = new Film();
		
		film.setTitle(title);
		film.setContent(content);
		if(plot == null || plot == "") film.setPlot(result.getPlot()); 							else film.setPlot(plot);
		if(year == null || year == "") film.setYear(result.getYear()); 							else film.setYear(year);
		if(director == null || director == "") film.setDirector(result.getDirector()); 			else film.setDirector(director);
		if(genre == null || genre == "") film.setGenre(result.getGenre()); 						else film.setGenre(genre);
		if(actors == null || actors == "") film.setActors(result.getActors()); 					else film.setActors(actors);
		if(poster == null || poster == "") film.setPoster(result.getPoster()); 					else film.setPoster(poster);
		if(imdbRating == null || imdbRating == "") film.setImdbRating(result.getImdbRating()); 	else film.setImdbRating(imdbRating);
		
		//TODO: Set a default image if none is provided.
		//if(film.getPoster() == null || film.getPoster() == "") film.setPoster("http://placehold.it/150x150");
		
		//TODO: Prevent same films
		
		//Guarda en la BBDD H2
		filmRepo.save(film);
		
		//Verificacion de compra
		String verification = film.getTitle();
		
		model.addAttribute("verification", verification);
		return new ModelAndView("purchase");
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/users")
	public ModelAndView processUsers(Model model,
			@RequestParam(value = "user", required=false) String name) {
		if (name == null || name == ""){
			Iterable<User> users = userRepo.findAll();
			return new ModelAndView("users").addObject("users", users);
		}
		User userToDelete = new User();
		userToDelete = userRepo.findByUser(name);
		model.addAttribute("verification", name);
		userRepo.delete(userToDelete);
		Iterable<User> users = userRepo.findAll();
		return new ModelAndView("users").addObject("users", users);
	}
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/watch")
	public ModelAndView processWatch(Model model, @RequestParam(value = "film") String title){
		Film film = new Film();
		film = filmRepo.findByTitle(title);
		model.addAttribute("film", film);
		return new ModelAndView("watch");
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/adduser")
	public ModelAndView processAddUsers(Model model,
			@RequestParam(value = "name", required=false) String name,
			@RequestParam(value = "password", required=false) String password,
			@RequestParam(value = "email", required=false) String email){
		if (name == null || name == ""){
			return new ModelAndView("adduser");
		}
        GrantedAuthority[] userRoles = {new SimpleGrantedAuthority("ROLE_USER") };
        userRepo.save(new User(name, password, email, Arrays.asList(userRoles)));
		model.addAttribute("verification", name);
        return new ModelAndView("adduser");
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/modifyuser")
	public ModelAndView processModifyUser(Model model,
			@RequestParam(value = "name", required=false) String name){
		User user = new User();
		user = userRepo.findByUser(name);
		model.addAttribute("name", user.getUser());
		model.addAttribute("email", user.getEmail());
        return new ModelAndView("modifyuser");
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/success")
	public ModelAndView processSuccess(Model model,
			@RequestParam(value = "name", required=false) String name,
			@RequestParam(value = "originalName", required=false) String originalName,
			@RequestParam(value = "password", required=false) String password,
			@RequestParam(value = "email", required=false) String email){
		User user = new User();
		user = userRepo.findByUser(originalName);
		if (name != null || name != ""){
			user.setUser(name);
		}
		if (password != null || password != ""){
			user.setPasswordHash(password);
			}
		if (email != null || email != ""){
			user.setEmail(email);
			}
		userRepo.save(user);
		model.addAttribute("verification", name);
        return new ModelAndView("success");
	}

}