package org.example.demo.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "copia_libro")
public class CopiaLibro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_copia_libro")
    private Integer idCopiaLibro;

    @Column(name = "prezzo_giornaliero")
    private Float prezzoGiornaliero;

    @ManyToOne
    @JoinColumn(name = "fk_libro", referencedColumnName = "id_libro")
    private Libro libro;

    @ManyToOne
    @JoinColumn(name = "fk_casa_editrice", referencedColumnName = "id_casa_editrice")
    private CasaEditrice casaEditrice;


    public Integer getIdCopiaLibro() {
        return idCopiaLibro;
    }

    public void setIdCopiaLibro(Integer idCopiaLibro) {
        this.idCopiaLibro = idCopiaLibro;
    }

    public Float getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    public void setPrezzoGiornaliero(Float prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public CasaEditrice getCasaEditrice() {
        return casaEditrice;
    }

    public void setCasaEditrice(CasaEditrice casaEditrice) {
        this.casaEditrice = casaEditrice;
    }
}