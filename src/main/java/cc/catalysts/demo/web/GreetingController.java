package cc.catalysts.demo.web;

import cc.catalysts.demo.model.Person;
import cc.catalysts.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Klaus Lehner
 */
@Controller
public class GreetingController {

    private final PersonService personService;

    @Autowired
    public GreetingController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping("/greeting")
    public ModelAndView greeting(@RequestParam(name = "nameParam") String name) {
        ModelAndView mav = new ModelAndView("greeting");
        mav.addObject("name", name);
        mav.addObject("hometown", "Amstetten");
        mav.addObject("personList", personService.findAll());
        return mav;
    }

    @ResponseBody
    @RequestMapping("/john")
    public Person john() {
        return new Person("john", "doe");
    }
}
