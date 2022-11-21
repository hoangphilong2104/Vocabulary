package com.hcmue.vocabulary.english.controller;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hcmue.vocabulary.english.model.AccountModel;
import com.hcmue.vocabulary.english.model.CategoryModel;
import com.hcmue.vocabulary.english.model.TypeOfWordsModel;
import com.hcmue.vocabulary.english.model.VocabularyDetailModel;
import com.hcmue.vocabulary.english.model.VocabularyModel;
import com.hcmue.vocabulary.english.model.VocabularyTypeModel;
import com.hcmue.vocabulary.english.services.AaccountServices;
import com.hcmue.vocabulary.english.services.CategoryServices;
import com.hcmue.vocabulary.english.services.TypeOfWordsServices;
import com.hcmue.vocabulary.english.services.VocabularyDetailServices;
import com.hcmue.vocabulary.english.services.VocabularyServices;
import com.hcmue.vocabulary.english.services.VocabularyTypeServices;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AaccountServices accountServices;
	@Autowired
	private CategoryServices categoryServices;
	@Autowired
	private VocabularyServices vocabularyServices;
	@Autowired
	private VocabularyTypeServices vocabularyTypeServices;
	@Autowired
	private VocabularyDetailServices vocabularyDetailServices;
	@Autowired
	private TypeOfWordsServices typeOfWordsServices;
	//Dash board
	@GetMapping("")
	public ModelAndView admin(ModelMap model) {
		int nAccount = accountServices.getRownum();
		int nVocabulary = vocabularyServices.getRownum();
		
		model.addAttribute("nAccount",nAccount);
		model.addAttribute("nVocabulary",nVocabulary);
		return new ModelAndView("admin/dashboard");
	}
	
	/*
	 * No: 			1
	 * Class: 		Account
	 * Comment:		
	 * 
	 */
	//show
	@GetMapping("/account")
	public ModelAndView showAccount(Model model) {
		List<AccountModel> list = accountServices.listAll();
		model.addAttribute("listItems", list);
		model.addAttribute("jclass",jclass(1));
		return new ModelAndView("admin/account/show","iclass",iclass(1));
	}
	
	//add
	@GetMapping("/account/add")
	public ModelAndView addAccount(Model model) {
		AccountModel accountModel = new AccountModel();
		model.addAttribute("item",accountModel);
		model.addAttribute("jclass",jclass(1));
		model.addAttribute("birthday",iformatToHTML(iparse(accountModel.getBirthday())));
		return new ModelAndView("admin/account/add","iclass",iclass(1));
	}
	
	@PostMapping("/account/add")
	public ModelAndView saveAccount(Model model, @ModelAttribute("item") AccountModel accountModel, @RequestParam("birthday")String birthday) {
		try {
			birthday = iformat(iparseHTMLtoCore(birthday));
			accountModel.setBirthday(birthday);
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			accountModel.setPassword(passwordEncoder.encode(accountModel.getPassword()));;
			accountServices.update(accountModel);
			return new ModelAndView("redirect:/admin/account");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/error?url=account/add");
	}
	
	//edit
	@GetMapping("/account/edit/{id}")
	public ModelAndView editAccount(Model model, @PathVariable("id") int id) {
		AccountModel accountModel = accountServices.findOne(id);
		model.addAttribute("item",accountModel);
		model.addAttribute("jclass",jclass(1));
		model.addAttribute("birthday",iformatToHTML(iparse(accountModel.getBirthday())));
		return new ModelAndView("admin/account/edit","iclass",iclass(1));
	}
	
	//delete
	@GetMapping("/account/delete/{id}")
	public ModelAndView deleteAccount(@PathVariable("id") int id) {
		accountServices.delete(id);
	return new ModelAndView("redirect:/admin/account");
	}
	
	/*
	 * No: 			2
	 * Class: 		Category
	 * Comment:		
	 * 
	 */
	//show
	@GetMapping("/category")
	public ModelAndView showCategory(Model model) {
		List<CategoryModel> list = categoryServices.listAll();
		model.addAttribute("listItems", list);
		model.addAttribute("jclass",jclass(2));
		return new ModelAndView("admin/category/show","iclass",iclass(2));
	}
	
	//add
	@GetMapping("/category/add")
	public ModelAndView addCategory(Model model) {
		CategoryModel categoryModel = new CategoryModel();
		model.addAttribute("item",categoryModel);
		model.addAttribute("jclass",jclass(2));
		model.addAttribute("date_create",iformatToHTML(iparse(categoryModel.getDate_create())));
		return new ModelAndView("admin/category/add","iclass",iclass(2));
	}
	
	@PostMapping("/category/add")
	public ModelAndView saveCategory(Model model, @ModelAttribute("item") CategoryModel categoryModel,@RequestParam("date_create")String date_create) {
		try {
			date_create = iformat(iparseHTMLtoCore(date_create));
			categoryModel.setDate_create(date_create);
			categoryServices.update(categoryModel);
			return new ModelAndView("redirect:/admin/category");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/error?url=category/add");
	}
	
	//edit
	@GetMapping("/category/edit/{id}")
	public ModelAndView editCategory(Model model, @PathVariable("id") int id) {
		CategoryModel categoryModel = categoryServices.findOne(id);
		model.addAttribute("item",categoryModel);
		model.addAttribute("jclass",jclass(2));
		model.addAttribute("date_create",iformatToHTML(iparse(categoryModel.getDate_create())));
		return new ModelAndView("admin/category/edit","iclass",iclass(2));
	}
	
	//delete
	@GetMapping("/category/delete/{id}")
	public ModelAndView deleteCategory(@PathVariable("id") int id) {
		categoryServices.delete(id);
	return new ModelAndView("redirect:/admin/category");
	}
	/*
	 * No: 			3
	 * Class: 		Vocabulary
	 * Comment:		
	 * 
	 */
	//show
	@GetMapping("/vocabulary")
	public ModelAndView showVocabulary(Model model) {
		List<VocabularyModel> list = vocabularyServices.listAll();
		model.addAttribute("listItems", list);
		model.addAttribute("jclass",jclass(3));
		return new ModelAndView("admin/vocabulary/show","iclass",iclass(3));
	}
	
	//add
	@GetMapping("/vocabulary/add")
	public ModelAndView addVocabulary(Model model) {
		VocabularyModel vocabularyModel = new VocabularyModel();
		model.addAttribute("item",vocabularyModel);
		model.addAttribute("jclass",jclass(3));
		model.addAttribute("category",categoryServices.listAllByDesc());
		return new ModelAndView("admin/vocabulary/add","iclass",iclass(3));
	}
	
	@PostMapping("/vocabulary/add")
	public ModelAndView saveVocabulary(Model model, @ModelAttribute("item") VocabularyModel vocabularyModel) {
		try {
			vocabularyModel.setSound(vocabularyModel.getSpelling().toLowerCase()+".mp3");
			vocabularyServices.update(vocabularyModel);
			return new ModelAndView("redirect:/admin/vocabulary");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/error?url=vocabulary/add");
	}
	
	//edit
	@GetMapping("/vocabulary/edit/{id}")
	public ModelAndView editVocabulary(Model model, @PathVariable("id") int id) {
		VocabularyModel vocabularyModel = vocabularyServices.findOne(id);
		model.addAttribute("item",vocabularyModel);
		model.addAttribute("jclass",jclass(3));
		model.addAttribute("category",categoryServices.listAllByDesc());
		return new ModelAndView("admin/vocabulary/edit","iclass",iclass(3));
	}
	
	//delete
	@GetMapping("/vocabulary/delete/{id}")
	public ModelAndView deleteVocabulary(@PathVariable("id") int id) {
		vocabularyServices.delete(id);
	return new ModelAndView("redirect:/admin/vocabulary");
	}
	/*
	 * No: 			4
	 * Class: 		Vocabulary Type
	 * Comment:		
	 * 
	 */
	//show
	@GetMapping("/vocabularyType")
	public ModelAndView showVocabularyType(Model model) {
		List<VocabularyTypeModel> list = vocabularyTypeServices.listAll();
		model.addAttribute("listItems", list);
		model.addAttribute("jclass",jclass(4));
		return new ModelAndView("admin/vocabularyType/show","iclass",iclass(4));
	}
	
	//add
	@GetMapping("/vocabularyType/add")
	public ModelAndView addVocabularyType(Model model) {
		VocabularyTypeModel vocabularyTypeModel = new VocabularyTypeModel();
		model.addAttribute("item",vocabularyTypeModel);
		model.addAttribute("jclass",jclass(4));
		model.addAttribute("vocabulary",vocabularyServices.listAllByDesc());
		model.addAttribute("typeOfWord",typeOfWordsServices.listAll());
		return new ModelAndView("admin/vocabularyType/add","iclass",iclass(4));
	}
	
	@PostMapping("/vocabularyType/add")
	public ModelAndView saveVocabularyType(Model model, @ModelAttribute("item") VocabularyTypeModel vocabularyTypeModel) {
		try {
			vocabularyTypeModel.setType(typeOfWordsServices.findOne(vocabularyTypeModel.getId_type_of_words()).getType_of_words());
			vocabularyTypeServices.update(vocabularyTypeModel);
			return new ModelAndView("redirect:/admin/vocabularyType");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/error?url=vocabularyType/add");
	}
	
	//edit
	@GetMapping("/vocabularyType/edit/{id}")
	public ModelAndView editVocabularyType(Model model, @PathVariable("id") int id) {
		VocabularyTypeModel vocabularyTypeModel = vocabularyTypeServices.findOne(id);
		model.addAttribute("item",vocabularyTypeModel);
		model.addAttribute("jclass",jclass(4));
		model.addAttribute("vocabulary",vocabularyServices.listAllByDesc());
		return new ModelAndView("admin/vocabularyType/edit","iclass",iclass(4));
	}
	
	//delete
	@GetMapping("/vocabularyType/delete/{id}")
	public ModelAndView deleteVocabularyType(@PathVariable("id") int id) {
		vocabularyTypeServices.delete(id);
	return new ModelAndView("redirect:/admin/vocabularyType");
	}
	/*
	 * No: 			5
	 * Class: 		Vocabulary Detail
	 * Comment:		
	 * 
	 */
	//show
	@GetMapping("/vocabularyDetail")
	public ModelAndView showVocabularyDetail(Model model) {
		List<VocabularyDetailModel> list = vocabularyDetailServices.listAll();
		model.addAttribute("listItems", list);
		model.addAttribute("jclass",jclass(5));
		return new ModelAndView("admin/vocabularyDetail/show","iclass",iclass(5));
	}
	
	//add
	@GetMapping("/vocabularyDetail/add")
	public ModelAndView addVocabularyDetail(Model model) {
		VocabularyDetailModel vocabularyDetailModel = new VocabularyDetailModel();
		model.addAttribute("item",vocabularyDetailModel);
		model.addAttribute("jclass",jclass(5));
		model.addAttribute("vocabularyType",vocabularyTypeServices.listAllByDesc());
		return new ModelAndView("admin/vocabularyDetail/add","iclass",iclass(5));
	}
	
	@PostMapping("/vocabularyDetail/add")
	public ModelAndView saveVocabularyDetail(Model model, @ModelAttribute("item") VocabularyDetailModel vocabularyDetailModel) {
		try {
			vocabularyDetailServices.update(vocabularyDetailModel);
			return new ModelAndView("redirect:/admin/vocabularyDetail");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/error?url=vocabularyDetail/add");
	}
	
	//edit
	@GetMapping("/vocabularyDetail/edit/{id}")
	public ModelAndView editVocabularyDetail(Model model, @PathVariable("id") int id) {
		VocabularyDetailModel vocabularyDetailModel = vocabularyDetailServices.findOne(id);
		model.addAttribute("item",vocabularyDetailModel);
		model.addAttribute("jclass",jclass(5));
		model.addAttribute("vocabularyType",vocabularyTypeServices.listAllByDesc());
		return new ModelAndView("admin/vocabularyDetail/edit","iclass",iclass(5));
	}
	
	//delete
	@GetMapping("/vocabularyDetail/delete/{id}")
	public ModelAndView deleteVocabularyDetail(@PathVariable("id") int id) {
		vocabularyDetailServices.delete(id);
	return new ModelAndView("redirect:/admin/vocabularyDetail");
	}
	/*
	 * No: 			6
	 * Class: 		Type Of Words
	 * Comment:		
	 * 
	 */
	//show
	@GetMapping("/typeOfWords")
	public ModelAndView showTypeOfWords(Model model) {
		List<TypeOfWordsModel> list = typeOfWordsServices.listAll();
		model.addAttribute("listItems", list);
		model.addAttribute("jclass",jclass(6));
		return new ModelAndView("admin/typeOfWords/show","iclass",iclass(6));
	}
	
	//add
	@GetMapping("/typeOfWords/add")
	public ModelAndView addTypeOfWords(Model model) {
		TypeOfWordsModel typeOfWordsModel = new TypeOfWordsModel();
		model.addAttribute("item",typeOfWordsModel);
		model.addAttribute("jclass",jclass(6));
		model.addAttribute("vocabularyType",vocabularyTypeServices.listAllByDesc());
		return new ModelAndView("admin/typeOfWords/add","iclass",iclass(6));
	}
	
	@PostMapping("/typeOfWords/add")
	public ModelAndView saveTypeOfWords(Model model, @ModelAttribute("item") TypeOfWordsModel typeOfWordsModel) {
		try {
			typeOfWordsServices.update(typeOfWordsModel);
			return new ModelAndView("redirect:/admin/typeOfWords");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/error?url=typeOfWords/add");
	}
	
	//edit
	@GetMapping("/typeOfWords/edit/{id}")
	public ModelAndView editTypeOfWords(Model model, @PathVariable("id") int id) {
		TypeOfWordsModel typeOfWordsModel = typeOfWordsServices.findOne(id);
		model.addAttribute("item",typeOfWordsModel);
		model.addAttribute("jclass",jclass(6));
		model.addAttribute("vocabularyType",vocabularyTypeServices.listAllByDesc());
		return new ModelAndView("admin/typeOfWords/edit","iclass",iclass(6));
	}
	
	//delete
	@GetMapping("/typeOfWords/delete/{id}")
	public ModelAndView deleteTypeOfWords(@PathVariable("id") int id) {
		typeOfWordsServices.delete(id);
	return new ModelAndView("redirect:/admin/typeOfWords");
	}
	/*
	 * No: 			7
	 * Class: 		Others
	 * Comment:		
	 * 
	 */
	@GetMapping("/error")
	public ModelAndView errorPage(ModelMap model, @RequestParam("url") String url) {
		if(url == null || url.equals("")) {
			url = "error1";
		}
		model.addAttribute("url",url);
	return new ModelAndView("admin/admin_error");
	}
	
	@GetMapping("/error1")
	public ModelAndView errorPage1() {
	return new ModelAndView("redirect:/admin");
	}
	
	public String iclass(int i) {
		String s = "";
		switch (i) {
		case 1:
			s = "Account";
			break;

		case 2:
			s = "Category";
			break;
			
		case 3:
			s = "Vocabulary";
			break;

		case 4:
			s = "Vocabulary Type";
			break;
		case 5:
			s = "Vocabulary Detail";
			break;
		case 6:
			s = "Type Of Words";
			break;
		}
		return s;
	}
	
	public String jclass(int i) {
		String s = "";
		switch (i) {
		case 1:
			s = "account";
			break;

		case 2:
			s = "category";
			break;
			
		case 3:
			s = "vocabulary";
			break;

		case 4:
			s = "vocabularyType";
			break;
		case 5:
			s = "vocabularyDetail";
			break;
		case 6:
			s = "typeOfWords";
			break;
		}
		return s;
	}
	
	public String iformat(Date date) {
		DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
		return dateformat.format(date);
	}
	
	public String iformatToHTML(Date date) {
		DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");
		return dateformat.format(date).replace("/", "-");
	}
	
	public Date iparse(String date){
		try {
			DateFormat dateformat = new SimpleDateFormat("dd/MM/yyyy");
			return dateformat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date();
	}
	
	public Date iparseHTMLtoCore(String date){
		try {
			DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			return dateformat.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Date();
	}
	
	@GetMapping("/saveImg/{id}")
	public ModelAndView showSavePhoto(@PathVariable("id")int id,ModelMap model) {
		AccountModel a = accountServices.findOne(id);
		String avatar = a.getAvatar();
		model.addAttribute("item",a);
		return new ModelAndView("admin/saveImg","avatar",avatar);
	}
	
	@PostMapping("/saveImg")
	public ModelAndView savePhoto(@RequestParam("photo") MultipartFile photo, ModelMap model,@RequestParam("id")int id) {
		String urlReturn = "admin/account";
		AccountModel a = accountServices.findOne(id);
		
		if(photo.isEmpty()) {
			return new ModelAndView("redirect:/"+urlReturn);
		}
		Path path = Paths.get("src/main/resources/static/img/");
		
		try {
			Files.createDirectories(path);
			InputStream inputStream = photo.getInputStream();
			Files.copy(inputStream, path.resolve(photo.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
			System.err.println("Copy");
			String infor = photo.getOriginalFilename().toLowerCase();
			a.setAvatar(infor);
			accountServices.update(a);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/"+urlReturn);
	}
}