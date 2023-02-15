package com.example.demo.Repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Model.pizzeriaModel;

public interface pizzeriaRepository extends JpaRepository<pizzeriaModel, Integer>{

	 public List<pizzeriaModel> findByNomeLike(String keyword);
	 public List<pizzeriaModel> findByPrezzo(Double prezzo);
	
}



