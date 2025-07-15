package org.example.demo.model.dto;

import org.example.demo.model.entity.CopiaLibro;
import org.example.demo.model.entity.Libro;

import java.util.List;

public class LibroDettaglioDto {
//    private String risposta;
    private Libro libro;
    private List<CopiaLibro> copieLibro;


    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public List<CopiaLibro> getCopieLibro() {
        return copieLibro;
    }

    public void setCopieLibro(List<CopiaLibro> copieLibro) {
        this.copieLibro = copieLibro;
    }

    public LibroDettaglioDto(Libro libro, List<CopiaLibro> copieLibro) {
        this.libro = libro;
        this.copieLibro = copieLibro;
    }

//    public LibroDettaglioDto(/*String risposta,*/Libro libro, List<CopiaLibro> copieLibro) {
//        this.risposta= risposta;
//        this.libro = libro;
//        this.copieLibro = copieLibro;
//    }

    public LibroDettaglioDto(/*String risposta*/) {
//        this.risposta= risposta;
    }



}
