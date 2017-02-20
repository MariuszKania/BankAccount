package pl.sda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import pl.sda.model.Client;
import pl.sda.model.User;
import pl.sda.service.ClientService;
import pl.sda.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClientService clientService;
	
	
	@RequestMapping(value="login.do", method=RequestMethod.GET)
    public ModelAndView newClientForm() {
        ModelAndView mav = new ModelAndView("login");
        User user = new User();
        mav.getModelMap().put("user", user);
        return mav;
    }
	 @RequestMapping(value="login.do", method=RequestMethod.POST)
	public ModelAndView login(@ModelAttribute("user") User user) {
		 ModelAndView mav = new ModelAndView(userService.login(user.getUsername(), user.getPassword()));
		 
		 mav.getModelMap().put("CLIENT", clientService.getAll());
		return mav;
	}
}
