package code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	@Autowired
	private TablonDeAnunciosRepository repo;

	@RequestMapping("/")
	public ModelAndView processHome(Model model) {
		model.addAttribute("anuncios", repo.findAll());
		Iterable<TablonDeAnuncios> anuncios = repo.findAll();
		return new ModelAndView("home").addObject("list", anuncios);
	}

	@RequestMapping("/insert")
	public ModelAndView processNew(@RequestParam String name, @RequestParam String subject,
			@RequestParam String Comment) {
		TablonDeAnuncios tablonDeAnuncios = new TablonDeAnuncios(name, subject, Comment);
		repo.save(tablonDeAnuncios);
		ModelAndView modelAndView = new ModelAndView("insert");
		return modelAndView;
	}

	@RequestMapping("/new")
	public ModelAndView processInsert() {
		return new ModelAndView("new");
	}
	
	@RequestMapping("/show")
	public ModelAndView processShow(@RequestParam long ID){
		TablonDeAnuncios anuncios = new TablonDeAnuncios();
		anuncios = repo.findOne(ID);
		ModelAndView modelAndView = new ModelAndView("show").addObject("anuncio", anuncios);
		return modelAndView;
	}

}

// http://jvmhub.com/2015/08/09/spring-boot-with-thymeleaf-tutorial-part-3-spring-data-jpa/