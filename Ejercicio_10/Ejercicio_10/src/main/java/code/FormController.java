package code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

	@Autowired
	private TablonDeAnunciosRepository repo;

	@RequestMapping("/")
	public ModelAndView process() {
		Iterable<TablonDeAnuncios> anuncios = repo.findAll();
		return new ModelAndView("home").addObject("list", anuncios);
	}
	
	
}