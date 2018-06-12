package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Mobile;


@Controller
public class Welcome {
    
	private List<Mobile> mobileList = new ArrayList<>();
	
    public Welcome() {
    	mobileList.add(new Mobile("华为手机", 4000));
    	mobileList.add(new Mobile("小米手机", 3000));
    	mobileList.add(new Mobile("苹果手机", 6000));
	}

    @RequestMapping(path = "/mobiles", method = RequestMethod.GET)
    public String mobile(Model model){
    	model.addAttribute("mList", this.mobileList);
    	
    	return "welcome";
    }
    
	@RequestMapping(path = "/user", method = RequestMethod.GET)
    public String user(@RequestParam(required = false) String uname, Model model){
    	System.out.println("受到您的请求");
    	model.addAttribute("uname", uname);
    	return "welcome";
    }
    
    

}
