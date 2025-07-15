package org.example.demo.model.dto;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class ClienteStoricoNoleggiDto {
    private String titolo;
    private String nomeCognome;
    private LocalDate dataInizio;
    private LocalDate dataFine;
    private Float prezzoGiornaliero;
    private Float scontoPercento;
    private Float totalePrezzo;
    private Float scontoTotale;
    private Float prezzoScontato;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getNomeCognome() {
        return nomeCognome;
    }

    public void setNomeCognome(String nomeCognome) {
        this.nomeCognome = nomeCognome;
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

    public Float getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    public void setPrezzoGiornaliero(Float prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    public Float getScontoPercento() {
        return scontoPercento;
    }

    public void setScontoPercento(Float scontoPercento) {
        this.scontoPercento = scontoPercento;
    }

    public Float getTotalePrezzo() {
        return totalePrezzo;
    }

    public void setTotalePrezzo(Float totaleSconto) {
        this.totalePrezzo = totaleSconto;
    }

    public Float getScontoTotale() {
        return scontoTotale;
    }

    public void setScontoTotale(Float scontoTotale) {
        this.scontoTotale = scontoTotale;
    }

    public Float getPrezzoScontato() {
        return prezzoScontato;
    }

    public void setPrezzoScontato(Float totaleScontato) {
        this.prezzoScontato = prezzoScontato;
    }

    public ClienteStoricoNoleggiDto(String titolo, String nome, String cognome, LocalDate dataInizio, LocalDate dataFine, Float prezzoGiornaliero, Float scontoPercento) {
        this.titolo = titolo;
        this.nomeCognome = cognome + " " + nome;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.prezzoGiornaliero = prezzoGiornaliero;
        this.scontoPercento = scontoPercento;
        if (dataFine == null) {
            this.prezzoScontato=null;
            this.scontoTotale=null;
            this.totalePrezzo=null;
        }
        else{
            long giorni = ChronoUnit.DAYS.between(dataInizio, dataFine);
            this.totalePrezzo = giorni * prezzoGiornaliero;
            this.scontoTotale = this.totalePrezzo * (scontoPercento / 100);
            Float prezzoScontato  = this.totalePrezzo - this.scontoTotale;
            this.prezzoScontato= prezzoScontato;
            }
    }


    public ClienteStoricoNoleggiDto() {
    }
}
