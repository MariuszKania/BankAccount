package pl.sda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import pl.sda.model.Client;
import pl.sda.model.ClientAccount;
import pl.sda.model.Deposit;
import pl.sda.model.User;
import pl.sda.service.ClientAccountService;
import pl.sda.service.ClientService;
import pl.sda.service.DepositService;
import pl.sda.service.UserService;

@Controller
public class ClientController {

	@Autowired
	private ClientService clientService;
	@Autowired
	private ClientAccountService clientAccountService;
	@Autowired
	private DepositService depositService; 
	
	@Autowired
	private UserService userService; 
	
	@RequestMapping("client.do")
	public String client(Model model) {
		List<Client> list = clientService.getAll();
		model.addAttribute("ALL_CLIENTS", list);
		return "client";
	}
	@RequestMapping(value="newClientForm.do", method=RequestMethod.GET)
    public ModelAndView newClientForm() {
        ModelAndView mav = new ModelAndView("newClientPage");
        Client client = new Client();
        mav.getModelMap().put("newClient", client);
        return mav;
    }
     
    @RequestMapping(value="saveClient.do", method=RequestMethod.POST)
    public String create(@ModelAttribute("newClient") Client client) {
    	User user = client.getUser();
    	user.setClient(client);
    	userService.save(user); 	 	
    	clientService.save(client);
        clientAccountService.createAccount(client.getId());
    	
        return "redirect:client.do";
    }
    @RequestMapping(value = "/showAccounts", method = RequestMethod.GET)
    public ModelAndView edit(@RequestParam("id") Long id) {
        ModelAndView mav = new ModelAndView("showAccounts");
        List<ClientAccount> accounts = clientAccountService.getAccountsByClientId(id);
        mav.addObject("ACCOUNTS", accounts);
        return mav;
    }
    
    @RequestMapping(value = "/showDeposits", method = RequestMethod.GET)
    public ModelAndView showDeposits(@RequestParam("id") Long id) {
        ModelAndView mav = new ModelAndView("showDeposits");
        List<Deposit> deposits = depositService.getDepositsByAccountId(id);
        mav.addObject("DEPOSITS", deposits);
        return mav;
    }
    @RequestMapping(value = "/addAccount", method = RequestMethod.GET)
    public String addAccount (@RequestParam("id") Long id) {
        clientAccountService.createAccount(id);
        return "redirect:client.do";

   }
}
