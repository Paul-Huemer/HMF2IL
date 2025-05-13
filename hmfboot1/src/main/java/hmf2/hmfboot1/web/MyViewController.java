package hmf2.hmfboot1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@Controller
public class MyViewController {
    @RequestMapping(value="/myview", method= RequestMethod.GET)
    public void myView(Model model) {
        model.addAttribute("message","Hello World!");
        model.addAttribute(new Date());
    }

}
