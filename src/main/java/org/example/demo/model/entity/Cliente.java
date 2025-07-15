package org.example.demo.model.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private Integer idCliente;

    @Column(name="nome")
    private String nome;

    @Column(name="cognome")
    private String cognome;

    @Column(name="data_nascita")
    private Date dataNascita;

    @Column(name="email")
    private String email;

    @Column(name="numero_carta_credito")
    private String numeroCartaCredito;

    /*@OneToMany(mappedBy="cliente", fetch=FetchType.LAZY)
    private List<Noleggio> noleggiDelCliente;*/


    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroCartaCredito() {
        return numeroCartaCredito;
    }

    public void setNumeroCartaCredito(String numeroCartaCredito) {
        this.numeroCartaCredito = numeroCartaCredito;
    }

    public Cliente(String nome, String cognome, Date dataNascita, String email, String numeroCartaCredito) {
        this.numeroCartaCredito = numeroCartaCredito;
        this.email = email;
        this.dataNascita = dataNascita;
        this.cognome = cognome;
        this.nome = nome;
    }
    public Cliente(){

    }
}
