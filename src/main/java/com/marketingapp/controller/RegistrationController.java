package com.marketingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.marketingapp.dto.RegistrationDto;
import com.marketingapp.entity.Registration;
import com.marketingapp.service.RegistrationService;


@Controller
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	

	
	//http://localhost:8080/view
	
	//Handler Methods - this method will interact with frontend and backend
	@RequestMapping("/view")
	public String viewRegistrationPage() {
		return "create_lead";
	}
	
	
	//3 ways to read the Form Data
	
	//1
//	@RequestMapping("/saveReg")
//	public String saveRegistration(@ModelAttribute Registration registration) {
//		registrationService.saveRegistration(registration);
//		
//		return "create_lead";
//	}
//	
	
	//2
//	@RequestMapping("/saveReg")
//	public String saveRegistration(
//			@RequestParam("firstName") String firstName ,
//			@RequestParam("lastName") String lastName ,
//			@RequestParam("email") String email ,
//			@RequestParam("mobile") long mobile
//			
//			
//			) {
//		
//		System.out.println(firstName);
//		System.out.println(lastName);
//		System.out.println(email);
//		System.out.println(mobile);
//		
//		Registration reg = new Registration();
//		reg.setFirstName(firstName);
//		reg.setLastName(lastName);
//		reg.setEmail(email);
//		reg.setMobile(mobile);
//		registrationService.saveRegistration(reg);
//		registrationService.saveRegistration(registration);
//		return "create_lead";
//	}
	
	//3
	@RequestMapping("/saveReg")
	public String saveRegistration( RegistrationDto dto, Model model) {
		Registration reg = new Registration();
		reg.setFirstName(dto.getFirstName());
		reg.setLastName(dto.getLastName());
		reg.setEmail(dto.getEmail());
		reg.setMobile(dto.getMobile());
		
		registrationService.saveRegistration(reg);
		
		
		model.addAttribute("msg", "Record is saved ");
		return "create_lead";
	}
	
	//Get All Record from Database
	@RequestMapping("/getAllReg")
	public String getAllRegistrations(Model model) {
		List<Registration> registrations = registrationService.getAllRegistrations();
//		System.out.println(registrations);
		
		model.addAttribute("registrations", registrations);
		return "list_registrations";
	}
	
	//Delete the record
	//RequestParam will get the id from url and store in id
	@RequestMapping("/delete")
	public String deleteLead(@RequestParam long id , Model model) {
		
		registrationService.deleteLead(id);
		List<Registration> registrations = registrationService.getAllRegistrations();
        model.addAttribute("registrations", registrations);
		return "list_registrations";
	}
	
	
	     //Update the record
		//RequestParam will get the id from url and store in id
		@RequestMapping("/update")
		public String viewUpdatePage(@RequestParam long id , ModelMap model) {
			Registration registration = registrationService.getRegistrationById(id);
			model.addAttribute("registration", registration);
			return "update_lead";
		}
		
		@RequestMapping("/updateReg")
		public String updateRegistration(RegistrationDto dto, Model model) {
			Registration reg = new Registration();
			reg.setId(dto.getId());
			reg.setFirstName(dto.getFirstName());
			reg.setLastName(dto.getLastName());
			reg.setEmail(dto.getEmail());
			reg.setMobile(dto.getMobile());
			
			registrationService.saveUpdateRegistration(reg);
			List<Registration> registrations = registrationService.getAllRegistrations();
	        model.addAttribute("registrations", registrations);
			return "list_registrations";
			
		}
	
	
	

}
