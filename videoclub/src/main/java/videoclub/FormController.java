package videoclub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

@Controller
public class FormController {

	@Autowired
	private FilmRepository repo;
	
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
		model.addAttribute("anuncios", repo.findAll());
		return new ModelAndView("home");
	}

	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/search")
	public ModelAndView processSearch() {
		Iterable<Film> films = repo.findAll();
		return new ModelAndView("search").addObject("Film", films);
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/purchase")
	public ModelAndView processPurchase() {
		//Llamada al servicio REST (OMBd)
		//Parsear la respuesta con Gson
		//Almacenar la respuesta en nuestra BBDD
		//Film film = new Film();
		return new ModelAndView("purchase");
	}
	
	@Secured({ "ROLE_ADMIN" })
	@RequestMapping("/users")
	public ModelAndView processUsers() {
		Iterable<User> users = userRepo.findAll();
        return new ModelAndView("users").addObject("Film", users);
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
	*/
	
	@Secured({ "ROLE_USER", "ROLE_ADMIN" })
	@RequestMapping("/show")
	public ModelAndView processShow(@RequestParam long ID){
		Film film = new Film();
		film = repo.findOne(ID);
		ModelAndView modelAndView = new ModelAndView("show").addObject("anuncio", film);
		return modelAndView;
	}

}

// http://jvmhub.com/2015/08/09/spring-boot-with-thymeleaf-tutorial-part-3-spring-data-jpa/