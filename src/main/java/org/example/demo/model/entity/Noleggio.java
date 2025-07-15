package org.example.demo.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="noleggio")
public class Noleggio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_noleggio")
    private Integer idNoleggio;

    @Column(name="metodo_pagamento")
    private String metodoPagamento;

    @Column(name="data_inizio")
    private LocalDate dataInizio;

    @Column(name="data_fine")
    private LocalDate dataFine;

    @Column(name= "sconto_%")
    private Float scontoPercentuale;

    @ManyToOne
    @JoinColumn(name="fk_cliente", referencedColumnName ="id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name= "fk_copia_libro", referencedColumnName = "id_copia_libro")
    private CopiaLibro copiaLibro;

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public Integer getIdNoleggio() {
        return idNoleggio;
    }

    public void setIdNoleggio(Integer idNoleggio) {
        this.idNoleggio = idNoleggio;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(LocalDate dataInizio) {
        this.dataInizio = dataInizio;
    }

    public LocalDate getDataFine() {
        return dataFine;
    }

    public void setDataFine(LocalDate dataFine) {
        this.dataFine = dataFine;
    }

    public Float getScontoPercentuale() {
        return scontoPercentuale;
    }

    public void setScontoPercentuale(Float scontoPercentuale) {
        this.scontoPercentuale = scontoPercentuale;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this. cliente = fkCliente;
    }

    public CopiaLibro getCopiaLibro() {
        return copiaLibro;
    }

    public void setCopiaLibro(CopiaLibro copiaLibro) {
        this.copiaLibro = copiaLibro;
    }

    public Noleggio(String metodoPagamento, LocalDate dataInizio, LocalDate dataFine, Cliente cliente, CopiaLibro copiaLibro, Float scontoPercentuale) {
        this.metodoPagamento = metodoPagamento;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.cliente = cliente;
        this.copiaLibro = copiaLibro;
        this.scontoPercentuale= scontoPercentuale;
    }

    public Noleggio() {
    }
}