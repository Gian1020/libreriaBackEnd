package org.example.demo.model.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;
import java.util.Date;

public class AutoreDto {

    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private LocalDate dataMorte;
    private String nazionalita;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public LocalDate getDataMorte() {
        return dataMorte;
    }

    public void setDataMorte(LocalDate dataMorte) {
        this.dataMorte = dataMorte;
    }

    public String getNazionalita() {
        return nazionalita;
    }

    public void setNazionalita(String nazionalita) {
        this.nazionalita = nazionalita;
    }

    public AutoreDto(String nome, String cognome, LocalDate dataNascita, LocalDate dataMorte, String nazionalita) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.dataMorte = dataMorte;
        this.nazionalita = nazionalita;
    }

    public AutoreDto() {
    }
}
