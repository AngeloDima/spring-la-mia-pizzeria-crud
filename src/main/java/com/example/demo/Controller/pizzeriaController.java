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

    @Autowired 
    pizzeriaRepository PizzeriaRepository;
	
    @GetMapping
    public String index(Model model) {
        List<pizzeriaModel> elencoPizze = PizzeriaRepository.findAll();
		
        model.addAttribute("elencoPizze", elencoPizze);
        return "home";
    }
}


