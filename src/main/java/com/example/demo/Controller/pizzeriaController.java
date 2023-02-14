package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model.pizzeriaModel;
import com.example.demo.Repository.pizzeriaRepository;



@Controller
@RequestMapping("/")
public class pizzeriaController {
pizzeriaModel pizza;

private @Autowired pizzeriaRepository PizzeriaRepository;
	
	@GetMapping
	public String index(Model model) {
		List<pizzeriaModel> pizze = PizzeriaRepository.findAll();
		
		model.addAttribute("pizze", pizze);
		return "books/index";
	}
}
