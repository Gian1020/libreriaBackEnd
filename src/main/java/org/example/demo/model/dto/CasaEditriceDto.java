package org.example.demo.model.dto;

public class CasaEditriceDto {

    private String risposta;

    private String nome;

    private String codiceFiscale;

    private String sedeCitta;

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getSedeCitta() {
        return sedeCitta;
    }

    public void setSedeCitta(String sedeCitta) {
        this.sedeCitta = sedeCitta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public CasaEditriceDto() {
    }

    public CasaEditriceDto(String risposta, String nome, String codiceFiscale, String sedeCitta) {
        this.risposta= risposta;
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.sedeCitta = sedeCitta;
    }

    public CasaEditriceDto(String risposta) {
        this.risposta = risposta;
    }
}
