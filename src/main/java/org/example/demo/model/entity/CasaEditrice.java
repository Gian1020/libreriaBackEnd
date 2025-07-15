package org.example.demo.model.entity;

import jakarta.persistence.*;
import org.example.demo.model.dto.CasaEditriceDto;

@Entity
@Table(name = "casa_editrice")
public class CasaEditrice extends CasaEditriceDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_casa_editrice")
    private Integer idCasaEditrice;

    @Column(name = "nome")
    private String nome;

    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    @Column(name = "sede_citta")
    private String sedeCitta;

    public Integer getIdCasaEditrice() {
        return idCasaEditrice;
    }

    public void setIdCasaEditrice(Integer idCasaEditrice) {
        this.idCasaEditrice = idCasaEditrice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
