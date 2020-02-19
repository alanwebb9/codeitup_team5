package com.codeitup_team5.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codeitup_team5.pojo.HealthData;
import com.codeitup_team5.services.HealthServices;


@Controller
public class homeController {
	@Autowired
	HealthServices healthServices;
	@RequestMapping(value = "/viewHome.action")

	public String list(
			 Model model,HttpSession session) {
		
		 
		List<HealthData> list_healthData= healthServices.viewalldata(null);
		
		model.addAttribute("list_healthData_page", list_healthData);
		return "home";
		
	}

}
