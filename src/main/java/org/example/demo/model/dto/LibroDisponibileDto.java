package org.example.demo.model.dto;

public class LibroDisponibileDto {
     private Integer idCopia;
     private String titolo;
     private String autore;
     private String genere;
     private Float prezzoGiornaliero;
     private String mondadori;

    public Integer getIdCopia() {
        return idCopia;
    }

    public void setIdCopia(Integer idCopia) {
        this.idCopia = idCopia;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    public String getMondadori() {
        return mondadori;
    }

    public void setMondadori(String mondadori) {
        this.mondadori = mondadori;
    }

    public Float getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    public void setPrezzoGiornaliero(Float prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    public LibroDisponibileDto(Integer idCopia, String titolo, String nome, String cognome, String genere, Float prezzoGiornaliero, String mondadori) {
        this.titolo = titolo;
        this.idCopia = idCopia;
        this.autore = cognome + " " + nome;
        this.genere = genere;
        this.prezzoGiornaliero= prezzoGiornaliero;
        this.mondadori = mondadori;
    }

    public LibroDisponibileDto() {
    }
}
