package org.example.demo.controller;

import org.example.demo.model.dto.CasaEditriceDto;
import org.example.demo.service.CasaEditriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/casaEditrice")
public class CasaEditriceController {

    @Autowired
    private CasaEditriceService casaEditriceService;

    @PostMapping(value = "/dettaglio")
    public CasaEditriceDto dettaglioCasaEditrice(@RequestParam Integer idCasaEditrice) {
        //Se il server non genera errore viene eseguito il blocco dentro try
        try {
            return casaEditriceService.CasaEditriceDettaglio(idCasaEditrice);
        }
        //Se genererà errore Il throw (presente nel service) entrerà direttamente nel catch
        // facendo tornare il messaggio d errore personalizzato
        catch (Exception e) {
            return new CasaEditriceDto("Errore: " + e.getMessage());
        }
    }
}

