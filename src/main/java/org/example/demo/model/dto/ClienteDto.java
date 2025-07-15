package org.example.demo.model.dto;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class ClienteDto {
    @NotNull
    private String nome;
    @NotNull
    private String cognome;
    @NotNull
    private Date dataNascita;
    @NotNull
    private String numeroCartaCredito;
    @NotNull
    private String email;

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getNumeroCartaCredito() {
        return numeroCartaCredito;
    }

    public void setNumeroCartaCredito(String cartaCredito) {
        this.numeroCartaCredito = cartaCredito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClienteDto(String nome, String cognome, Date dataNascita, String numeroCartaCredito, String email) {
        this.nome = nome;
        this.cognome = cognome;
        this.dataNascita = dataNascita;
        this.numeroCartaCredito = numeroCartaCredito;
        this.email = email;
    }
}
