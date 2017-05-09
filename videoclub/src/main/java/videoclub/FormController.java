package videoclub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
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
	
	//Se muestra
	//TODO: Logout al parecer, no funciona...
	@RequestMapping("/")
	public ModelAndView processLogin() {
        return new ModelAndView("login");
	}
	
	//Se muestra
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/home")
	public ModelAndView processHome(Model model) {
		model.addAttribute("anuncios", filmRepo.findAll());
		return new ModelAndView("home");
	}
	
	//Se muestra
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/search")
	public ModelAndView processSearch(@RequestParam(value = "title", required=false) String title) {
		if (title == null){
			Iterable<Film> films = filmRepo.findAll();
			return new ModelAndView("search").addObject("films", films);
		}
		//TODO: Como buscar solo una pelicula (findOne busca por ID (que no tenemos))
		Film films = filmRepo.findByTitle(title);
		
		//Preguntar si hay que parsear los datos de film para mostrarlos por HTML o  no es necesario. variables privadas
		
		//model.addAttribute("films", result);
		return new ModelAndView("search").addObject("Film", films);
	}
	
	//Se muestra
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/purchase")
	public ModelAndView processPurchase(Model model, @RequestParam(value = "title", required=false) String title) {
		if (title == null){
			return new ModelAndView("purchase");
		}
		//Llamada al servicio REST (OMBd)
		RestAdapter adapter = new RestAdapter.Builder().setEndpoint("http://www.omdbapi.com").build();
		OMDbService service = adapter.create(OMDbService.class);
		Film result = service.getFilm(title);
		filmRepo.save(result);
		String verification = "You have purchased: " + result.gettitle();
		
		model.addAttribute("verification", verification);
		return new ModelAndView("purchase");
	}
	
	//Se muestra
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/users")
	public ModelAndView processUsers() {
		Iterable<User> users = userRepo.findAll();
        return new ModelAndView("users").addObject("Film", users);
	}
	
	//TODO: No se muestra.
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/watch")
	public ModelAndView processWatch(){
		Film film = new Film();
		return new ModelAndView("watch").addObject("film", film);
	}

	
	/*
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/insert")
	public ModelAndView processNew(@RequestParam String name, @RequestParam String subject,
			@RequestParam String Comment) {
		Film film = new Film(name);
		repo.save(film);
		ModelAndView modelAndView = new ModelAndView("insert");
		return modelAndView;
	}

	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/new")
	public ModelAndView processInsert() {
		return new ModelAndView("new");
	}
	
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/show")
	public ModelAndView processShow(@RequestParam long ID){
		Film film = new Film();
		film = repo.findOne(ID);
		ModelAndView modelAndView = new ModelAndView("show").addObject("anuncio", film);
		return modelAndView;
	}
	*/
	

}