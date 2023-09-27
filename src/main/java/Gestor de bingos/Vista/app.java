
/**
 * Write a description of class app here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class app
{
    @GetMapping("/")
    public String saludo() {
        return "saludo";
    }


}
