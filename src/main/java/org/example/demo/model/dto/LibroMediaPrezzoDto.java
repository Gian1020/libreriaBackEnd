package org.example.demo.model.dto;

public class LibroMediaPrezzoDto {
    private String titolo;
    private Double prezzo_medio;

    public Double getPrezzo_medio() {
        return prezzo_medio;
    }

    public void setPrezzo_medio(Double prezzo_medio) {
        this.prezzo_medio = prezzo_medio;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LibroMediaPrezzoDto(String titolo, Double prezzo_medio) {
        this.titolo = titolo;
        this.prezzo_medio = prezzo_medio;
    }

    public LibroMediaPrezzoDto() {
    }
}
