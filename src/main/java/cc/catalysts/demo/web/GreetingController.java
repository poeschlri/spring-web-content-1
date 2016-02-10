package cc.catalysts.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Klaus Lehner
 */
@Controller
public class GreetingController {

    @RequestMapping("/greeting")
    public ModelAndView greeting(@RequestParam(name = "nameParam") String name) {
        ModelAndView mav = new ModelAndView("greeting");
        mav.addObject("name", name);
        mav.addObject("hometown", "Amstetten");

        return mav;
    }

}