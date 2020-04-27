package springdata2.relationships.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.validation.BindingResult;

import springdata2.relationships.models.License;
import springdata2.relationships.models.Person;
import springdata2.relationships.services.LicenseService;
import springdata2.relationships.services.PersonService;

@Controller
public class RelationshipsController {
	private final PersonService prsnServ;
	private final LicenseService lcsServ;
	private String number;
	
	public RelationshipsController(PersonService prsnServ, LicenseService lcsServ) {
		this.prsnServ = prsnServ;
		this.lcsServ = lcsServ;
	}
	
	@RequestMapping("")
	public String home() {
		return "relationships/home.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(@ModelAttribute License l, Model model) {
		model.addAttribute("persons", prsnServ.allPersons());
		return "relationships/licenses.jsp";
	}
	
	@RequestMapping(value="/licenses/new", method=RequestMethod.POST)
	public String createLicense(@Valid @ModelAttribute License l, BindingResult reslt, Model model) {
		if(reslt.hasErrors()) {
			model.addAttribute("persons", prsnServ.allPersons());
			return "relationships/licenses.jsp";
		}
		else {
			int count = (int) lcsServ.getCount();
			int num = count+1;
			if(num<10) {
				number = "00000"+num;
			}
			else if(num<100) {
				number = "0000"+num;
			}
			else if(num<1000) {
				number = "000"+num;
			}
			else if(num<10000) {
				number = "00"+num;
			}
			else if(num<100000) {
				number = "0"+num;
			}
			else {
				number = ""+num;
			}
			l.setNumber(number);
			lcsServ.createLicense(l);
			return "redirect:/licenses/new";
		}
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute Person p) {
		return "relationships/persons.jsp";
	}
	
	@RequestMapping(value="/persons/new", method=RequestMethod.POST)
	public String createPerson(@Valid @ModelAttribute Person p, BindingResult reslt) {
		if(reslt.hasErrors()) {
			return "relationships/persons.jsp";
		}
		else {
			prsnServ.createPerson(p);
			return "redirect:/persons/new";
		}
	}
	
	@RequestMapping("/persons")
	public String searchPerson(@RequestParam("id") Long id, Model model) {
		Person p = prsnServ.findPersonById(id);
		License l = lcsServ.findByPerson_id(id);
		if(p==null) {
			model.addAttribute("error", "There is no person with this ID in the database.");
			return "relationships/home.jsp";
		}
		else {
			model.addAttribute("license", l);
			model.addAttribute("person", p);
			return "relationships/profile.jsp";
		}
	}
}
