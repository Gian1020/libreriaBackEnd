package org.example.demo.model.dto;

import java.util.Date;

public class ClienteModificaDto extends ClienteDto{
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClienteModificaDto(String nome, String cognome, Date dataNascita, String numeroCartaCredito, String email, Integer id) {
        super(nome, cognome, dataNascita, numeroCartaCredito, email);
        this.id = id;
    }
}
