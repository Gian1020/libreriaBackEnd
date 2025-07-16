package org.example.demo.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "autore")
public class Autore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autore")
    private Integer idAutore;

    @NotNull
    @Column(name = "nome")
    private String nome;

    @NotNull
    @Column(name = "cognome")
    private String cognome;

    @NotNull
    @Column(name = "data_nascita")
    private LocalDate dataNascita;

    @Column(name = "data_morte")
    private LocalDate dataMorte;

    @Column(name = "nazionalita")
    private String nazionalita;

    public Integer getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(Integer idAutore) {
        this.idAutore = idAutore;
    }

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

    public Autore(String cognome, LocalDate dataNascita, LocalDate dataMorte, String nazionalita, String nome) {
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.dataMorte = dataMorte;
        this.nazionalita = nazionalita;
        this.nome = nome;
    }

    public Autore() {
    }
}
