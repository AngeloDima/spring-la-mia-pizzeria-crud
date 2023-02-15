package com.example.demo.Model;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name ="pizze")
public class pizzeriaModel {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id ;
	
    @NonNull
    @Column(nullable = false)
    private String nome;
	
    private String descrizione;
	
    @NonNull
    @Column(nullable = false)
    private Double prezzo;
	
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public Double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(Double prezzo) {
        this.prezzo = prezzo;
    }

    public Integer getId() {
        return id;
    }
}




