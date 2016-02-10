package cc.catalysts.demo.web;

import cc.catalysts.demo.model.Person;
import cc.catalysts.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @author Klaus Lehner
 */
@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView personList() {
        ModelAndView mav = new ModelAndView("person");
        mav.addObject("personList", personService.findAll());
        return mav;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public View createPerson(Person person) {
        personService.create(person);
        return new RedirectView("/");
    }
}
