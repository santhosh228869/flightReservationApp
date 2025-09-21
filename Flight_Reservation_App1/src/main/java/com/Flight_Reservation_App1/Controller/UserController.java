package com.Flight_Reservation_App1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Flight_Reservation_App1.Entity.User;
import com.Flight_Reservation_App1.Repository.UserRepository;

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	@RequestMapping("/showLoginPage")
	public String showLoginPage() {
		return"login/login";
	}
	
@RequestMapping("/showReg")
	public String showReg() {
		return"login/showReg";
	}
@RequestMapping("/saveReg")
public String saveReg(@ModelAttribute ("user") User user) {
	userRepo.save(user);
	return"login/login";
}
@RequestMapping("/verifyLogin")
public String verifyLogin(@RequestParam("emailid") String emailId,
		@RequestParam("password")String password,ModelMap modelmap) {
	User user = userRepo.findByEmail(emailId);
	if(user!=null) {
	if(user.getEmail().equals(emailId)&&user.getPassword().equals(password)) {
		return"FindFlight";
	}else {
		modelmap.addAttribute("error", "Invalid UserName / Password");
		return"login/login";
	}
	}else {
		modelmap.addAttribute("error", "Invalid UserName / Password");
		return"login/login";
	}
}
}
