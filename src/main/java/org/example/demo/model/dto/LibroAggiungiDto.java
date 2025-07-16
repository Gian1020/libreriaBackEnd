package org.example.demo.model.dto;

public class LibroAggiungiDto {
    private String titolo;

    private String genere;

    private Integer annoPubblicazione;

    private String nomeAutore;

    private String cognomeAutore;

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnnoPubblicazione(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getCognomeAutore() {
        return cognomeAutore;
    }

    public void setCognomeAutore(String cognomeAutore) {
        this.cognomeAutore = cognomeAutore;
    }

    public String getNomeAutore() {
        return nomeAutore;
    }

    public void setNomeAutore(String nomeAutore) {
        this.nomeAutore = nomeAutore;
    }

    public LibroAggiungiDto(String titolo, String genere, Integer annoPubblicazione) {
        this.titolo = titolo;
        this.genere = genere;
        this.annoPubblicazione = annoPubblicazione;
    }

    public LibroAggiungiDto(String titolo, String genere, Integer annoPubblicazione, String nomeAutore, String cognomeAutore) {
        this.titolo = titolo;
        this.genere = genere;
        this.annoPubblicazione = annoPubblicazione;
        this.nomeAutore = nomeAutore;
        this.cognomeAutore = cognomeAutore;
    }

    public LibroAggiungiDto() {
    }
}
