package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Model.pizzeriaModel;
import com.example.demo.Repository.pizzeriaRepository;

@Controller
@RequestMapping("/")
public class pizzeriaController {

    @Autowired
    pizzeriaRepository repository;

    @GetMapping
    public String index(@RequestParam(name = "keyword", required = false) String keyword,
            @RequestParam(name = "prezzo", required = false) Double prezzo, Model model) {
        List<pizzeriaModel> elencoPizze;

        if (keyword != null && !keyword.isEmpty()) {
            elencoPizze = repository.findByNomeLike("%" + keyword + "%");
        } else if (prezzo != null) {
            elencoPizze = repository.findByPrezzo(prezzo);
        } else {
            elencoPizze = repository.findAll();
        }

        model.addAttribute("elencoPizze", elencoPizze);
        return "home";
    }

    
    
    //crea
    
    @GetMapping("/create")
    public String create(Model model) {
        pizzeriaModel pizzeria = new pizzeriaModel();
        model.addAttribute("pizzeria", pizzeria);
        return "create";
    }

    @PostMapping("/create")
    public String store(@ModelAttribute("pizzeria") pizzeriaModel formPizzeria, Model model) {
        repository.save(formPizzeria);
        return "redirect:/";
    }


	
    
    @GetMapping("pizza/{id}")
    public String detail(@PathVariable("id") Integer id, Model model) {
    	pizzeriaModel elencoPizze = repository.getReferenceById(id);
    	model.addAttribute("pizza", elencoPizze);
    	return "pizza";
    	
    }
}


