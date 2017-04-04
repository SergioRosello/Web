package code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("new")
	public ModelAndView processNew(@ModelAttribute TablonDeAnuncios tablonDeAnuncios){
		 ModelAndView modelAndView = new ModelAndView("new");
		 modelAndView.addObject("name", tablonDeAnuncios.getNombre());
		 modelAndView.addObject("subject", tablonDeAnuncios.getDescripcion());
		 modelAndView.addObject("comment", tablonDeAnuncios.getAsunto());
		 repo.save(new TablonDeAnuncios(tablonDeAnuncios.getNombre(), tablonDeAnuncios.getDescripcion(), tablonDeAnuncios.getAsunto()));
		return modelAndView;
	}
	
	@RequestMapping("insert")
	public ModelAndView processInsert(){
		return new ModelAndView("insert");
	}
	
}


// http://jvmhub.com/2015/08/09/spring-boot-with-thymeleaf-tutorial-part-3-spring-data-jpa/