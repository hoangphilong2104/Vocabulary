package com.hcmue.vocabulary.english.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.vocabulary.english.model.AccountModel;
import com.hcmue.vocabulary.english.model.ItemDetailModel;
import com.hcmue.vocabulary.english.model.VocabularyModel;
import com.hcmue.vocabulary.english.services.AaccountServices;
import com.hcmue.vocabulary.english.services.ItemDetailServices;
import com.hcmue.vocabulary.english.services.QuizServices;
import com.hcmue.vocabulary.english.services.VocabularyServices;

@RestController
public class HomeController {
	
	@Autowired
	private AaccountServices accountServices;
//	@Autowired
//	private CategoryServices categoryServices;
	@Autowired
	private VocabularyServices vocabularyServices;
//	@Autowired
//	private VocabularyTypeServices vocabularyTypeServices;
//	@Autowired
//	private VocabularyDetailServices vocabularyDetailServices;
	@Autowired
	private ItemDetailServices itemDetailServices;
	@Autowired
	private QuizServices quizServices;
	
	@Value("${weburl}")
	private String weburl;
	
	@RequestMapping(value = "")
	public ModelAndView Home(Principal principal, ModelMap model) {
		model.addAttribute("suggestions",vocabularyServices.listSuggestions());
		model.addAttribute("weburls",weburl+"search?q=");
		if(principal != null) {
			return new ModelAndView("home","username",principal.getName());
		}
		return new ModelAndView("home");
	}
	
	@RequestMapping(value = "/processHome")
	public ModelAndView userProcessHome(Principal principal) {
		String username = principal.getName();
		if(username.equals("admin")) {
			return new ModelAndView("redirect:/admin");
		}
		return new ModelAndView("redirect:/");
	}
	
	//Login
	@GetMapping(value = "/login")
	public ModelAndView loginPage(Model model,Principal principal) {
		if(principal != null) {
			return new ModelAndView("redirect:/logout");
		}
		return new ModelAndView("login");
	}
	
	//Login
	@GetMapping(value = "/loginq")
	public ModelAndView loginqPage(Model model,Principal principal, @RequestParam("q") String q) {
		if(principal != null) {
			return new ModelAndView("redirect:/logout");
		}
		return new ModelAndView("login","q",q);
	}
		
	//error login
	@GetMapping(value = "/login_error")
	public ModelAndView loginError(Model model) {
		model.addAttribute("stringError","faild");
		return new ModelAndView("login");
	}
	
	//Register
	@GetMapping(value = "/register")
	public ModelAndView registerPage(Model model) {
		model.addAttribute("account", new AccountModel());
		return new ModelAndView("register");
	}
	
	//Register
	@GetMapping(value = "/register_error")
	public ModelAndView registerPageError(Model model) {
		model.addAttribute("khachHang", new AccountModel());
		model.addAttribute("stringError", "An error occurred while registering, you need to check again");
		return new ModelAndView("register");
	}
		
	//Register
	@PostMapping(value = "/register")
	public ModelAndView registerProcessPage(Model model, @ModelAttribute("account") AccountModel account, @RequestParam("confirm_password") String confirm_password
			,@RequestParam("birthday") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date birthday) {
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		account.setBirthday(dateformat.format(birthday));
		Boolean register = accountServices.register(account,confirm_password);
		if(register == true) {
			return new ModelAndView("redirect:/login_s");
		}else {
			return new ModelAndView("redirect:/register_error");
		}
		
	}
	
	@GetMapping(value = "/login_s")
	public ModelAndView loginS(Model model) {
		model.addAttribute("stringS","Register Successful");
		model.addAttribute("items", new AccountModel());
		return new ModelAndView("login");
	}
	
	// Logout
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return new ModelAndView("redirect:/login");
	}
	
	@RequestMapping(value = "/search")
	public ModelAndView search(Principal principal,ModelMap model,@RequestParam("q")String q) {
		model.addAttribute("suggestions",vocabularyServices.listSuggestions());
		model.addAttribute("weburls",weburl+"search?q=");
		VocabularyModel item = vocabularyServices.findOne(q.toUpperCase());
		if(item != null) {
			model.addAttribute("item",item);
			List<ItemDetailModel> items = itemDetailServices.listById(item.getId_vocabulary());
			if(items != null) {
				model.addAttribute("items",items);
			}
		}
		if(principal != null) {
			return new ModelAndView("vocabulary","username",principal.getName());
		}
		return new ModelAndView("vocabulary");
	}
	
	@RequestMapping(value = "/about")
	public ModelAndView About(Principal principal,ModelMap model) {
		model.addAttribute("suggestions",vocabularyServices.listSuggestions());
		model.addAttribute("weburls",weburl+"search?q=");
		if(principal != null) {
			return new ModelAndView("about","username",principal.getName());
		}
		return new ModelAndView("about");
	}
	
	@RequestMapping(value = "/contact")
	public ModelAndView Contact(Principal principal,ModelMap model) {
		model.addAttribute("suggestions",vocabularyServices.listSuggestions());
		model.addAttribute("weburls",weburl+"search?q=");
		if(principal != null) {
			return new ModelAndView("contact","username",principal.getName());
		}
		return new ModelAndView("contact");
	}
	
	@RequestMapping(value = "/gameE")
	public ModelAndView GameE(Principal principal,ModelMap model) {
		model.addAttribute("questionModel",quizServices.listAll());
		model.addAttribute("weburl",weburl+"gameE");
		if(principal != null) {
			return new ModelAndView("game","username",principal.getName());
		}
		return new ModelAndView("game");
	}
	
	@RequestMapping(value = "/gameV")
	public ModelAndView GameV(Principal principal,ModelMap model) {
		model.addAttribute("questionModel",quizServices.listAllVietName());
		model.addAttribute("weburl",weburl + "gameV");
		if(principal != null) {
			return new ModelAndView("game","username",principal.getName());
		}
		return new ModelAndView("game");
	}
}
