package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class Welcome {

    @RequestMapping(path="/hello", method = RequestMethod.GET)
    public String helloUser(@RequestParam(required=false) String uname, Model model) {
    	
    	System.out.println("收到了客户端的请求");
    	model.addAttribute("uname", "MARK");
    	return "welcome";
    }
    
    @RequestMapping(path = "/user", method = RequestMethod.GET)
    public String user(@RequestParam(required = false) String uname, Model model){
    	System.out.println("收到了客户端的请求");
    	model.addAttribute("uname", uname);
    	return "welcome";
    }

}
