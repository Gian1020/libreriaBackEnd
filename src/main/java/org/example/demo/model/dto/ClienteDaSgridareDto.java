package org.example.demo.model.dto;

import java.time.LocalDate;
import java.util.Date;

public class ClienteDaSgridareDto {
    private String nome;
    private String cognome;
    private String email;
    private String titolo;
    private LocalDate dataInizio;

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

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public ClienteDaSgridareDto(String nome, String cognome, String email, String titolo, LocalDate dataInizio) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.titolo = titolo;
        this.dataInizio = dataInizio;
    }

    public ClienteDaSgridareDto() {
    }
}
