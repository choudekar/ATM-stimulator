package in.co.online.bank.mgt.ctl;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/** WelcomeCtl Implementation
 */

@Controller
@RequestMapping(value = {"/welcome","/"})
public class WelcomeCtl {
	
	@RequestMapping(method = RequestMethod.GET)
    public String display() {
        return "welcome";
    }
	
	
	

}
