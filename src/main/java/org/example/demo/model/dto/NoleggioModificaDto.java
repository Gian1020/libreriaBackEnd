package org.example.demo.model.dto;

import java.time.LocalDate;
import java.util.Date;

public class NoleggioModificaDto {
    private Integer idNoleggio;
    private String metodoPagamento;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private Float scontoPercentuale;
    private Integer fkCliente;
    private Integer  fkCopiaLibro;

    public Integer getIdNoleggio() {
        return idNoleggio;
    }

    public void setIdNoleggio(Integer idNoleggio) {
        this.idNoleggio = idNoleggio;
    }

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

    public Float getScontoPercentuale() {
        return scontoPercentuale;
    }

    public void setScontoPercentuale(Float scontoPercentuale) {
        this.scontoPercentuale = scontoPercentuale;
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

    public NoleggioModificaDto(Integer idNoleggio, String metodoPagamento, LocalDate dataInizio, LocalDate dataFine, Float scontoPercentuale, Integer fkCliente, Integer fkCopiaLibro) {
        this.idNoleggio = idNoleggio;
        this.metodoPagamento = metodoPagamento;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.scontoPercentuale = scontoPercentuale;
        this.fkCliente = fkCliente;
        this.fkCopiaLibro = fkCopiaLibro;
    }

    public NoleggioModificaDto() {
    }
}
