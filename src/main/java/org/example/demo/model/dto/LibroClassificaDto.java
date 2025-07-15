package org.example.demo.model.dto;

public class LibroClassificaDto {
    private String titolo;
    private Long conteggio;

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Long getConteggio() {
        return conteggio;
    }

    public void setConteggio(Long conteggio) {
        this.conteggio = conteggio;
    }

    public LibroClassificaDto(String titolo, Long conteggio) {
        this.titolo = titolo;
        this.conteggio = conteggio;
    }

    public LibroClassificaDto() {
    }
}
