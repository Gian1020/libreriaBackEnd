package org.example.demo.model.dto;

import java.util.HashMap;
import java.util.Map;

public class FatturatoMensileDto {
    private String mese;
    private Double fatturatoLordo;
    private Double fatturatoScontato;

    public String getMese() {
        return mese;
    }

    public void setMese(String mese) {
        this.mese = mese;
    }

    public Double getFatturatoLordo() {
        return fatturatoLordo;
    }

    public void setFatturatoLordo(Double fatturatoLordo) {
        this.fatturatoLordo = fatturatoLordo;
    }

    public Double getFatturatoScontato() {
        return fatturatoScontato;
    }

    public void setFatturatoScontato(Double fatturatoScontato) {
        this.fatturatoScontato = fatturatoScontato;
    }

    public FatturatoMensileDto(String mese, Double fatturatoLordo, Double fatturatoScontato) {
        this.mese = mese;
        this.fatturatoLordo = fatturatoLordo;
        this.fatturatoScontato = fatturatoScontato;
    }

    public FatturatoMensileDto(Integer mese, Double fatturatoLordo, Double fatturatoScontato) {
        Map<Integer, String> nomeMese = new HashMap<Integer, String>();
        nomeMese.put(1, "Gennaio");
        nomeMese.put(2, "Febbraio");
        nomeMese.put(3, "Marzo");
        nomeMese.put(4, "Aprile");
        nomeMese.put(5, "Maggio");
        nomeMese.put(6, "Giugno");
        nomeMese.put(7, "Luglio");
        nomeMese.put(8, "Agosto");
        nomeMese.put(9, "Settembre");
        nomeMese.put(10, "Ottobre");
        nomeMese.put(11, "Novembre");
        nomeMese.put(12, "Dicembre");

        this.mese = nomeMese.get(mese);
        this.fatturatoLordo = fatturatoLordo;
        this.fatturatoScontato = fatturatoScontato;
    }

    public FatturatoMensileDto() {
    }
}
