package org.example.demo.model.dto;

import java.time.LocalDate;

public class NoleggioDto {
    private String metodoPagamento;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private Integer fkCliente;
    private Integer fkCopiaLibro;
    private Float scontoPercentuale;

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
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

    public Integer getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Integer fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Integer getFkCopiaLibro() {
        return fkCopiaLibro;
    }

    public void setFkCopiaLibro(Integer fkCopiaLibro) {
        this.fkCopiaLibro = fkCopiaLibro;
    }

    public Float getScontoPercentuale() {
        return scontoPercentuale;
    }

    public void setScontoPercentuale(Float scontoPercentuale) {
        this.scontoPercentuale = scontoPercentuale;
    }

    public NoleggioDto(String metodoPagamento, LocalDate dataInizio, LocalDate dataFine ,Integer fkCliente, Integer fkCopiaLibro, Float scontoPercentuale) {
        this.metodoPagamento = metodoPagamento;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.fkCliente= fkCliente;
        this.fkCopiaLibro = fkCopiaLibro;
        this.scontoPercentuale = scontoPercentuale;
    }

    public NoleggioDto() {
    }
}
