package hmf2.hmfboot1.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.io.Writer;
import java.util.Date;

@Controller
@RequestMapping("/hello")
public class HelloController  {
    @RequestMapping(method= RequestMethod.GET)
    public void hello (Writer out) throws IOException {
        out.write("Hello World and Spring Boot at "+new Date());
    }
}
