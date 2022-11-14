package com.hcmue.vocabulary.english.controller;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.vocabulary.english.model.AccountModel;
import com.hcmue.vocabulary.english.services.AaccountServices;

@RestController
public class HomeController {
	
	@Autowired
	private AaccountServices accountServices;
	
	@RequestMapping(value = "")
	public ModelAndView Home(Principal principal) {
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
}
