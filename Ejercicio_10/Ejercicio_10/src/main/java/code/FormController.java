package code;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FormController {

    @RequestMapping("/processForm1")
    public ModelAndView process(@ModelAttribute FormService input) {
        return new ModelAndView("result").addObject("result", input.getInput());
    }
}