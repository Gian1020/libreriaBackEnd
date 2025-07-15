package org.example.demo.model.dto;

public class LibroAggiungiDto {
    private String titolo;

    private String genere;

    private Integer annoPubblicazione;

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

    public LibroAggiungiDto(String titolo, String genere, Integer annoPubblicazione) {
        this.titolo = titolo;
        this.genere = genere;
        this.annoPubblicazione = annoPubblicazione;
    }

    public LibroAggiungiDto() {
    }
}
