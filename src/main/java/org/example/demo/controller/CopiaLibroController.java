package org.example.demo.controller;

import org.example.demo.model.dto.LibroMediaPrezzoDto;
import org.example.demo.model.entity.CopiaLibro;
import org.example.demo.service.CopiaLibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path ="/copiaLibro")
public class CopiaLibroController {
    @Autowired
    private CopiaLibroService copiaLibroService;

    @PostMapping(value = "/listaPrezzoMedio")
    public List<LibroMediaPrezzoDto> listaPrezzoMedio(){
        return copiaLibroService.listaTitoloPrezzoMedio();
    }

    @PostMapping(value = "/eliminaCopiaLibro")
    public String eliminaCliente(@RequestParam Integer CopiaLibro) {
        //Se il server non genera errore viene eseguito il blocco dentro try
        try {
            return copiaLibroService.eliminaCopiaLibro(CopiaLibro);
        }
        //Se genererà errore Il throw (presente nel service) entrerà direttamente nel catch
        // facendo tornare il messaggio d errore personalizzato
        catch (Exception e) {
           return "Errore: " +e.getMessage();
        }
    }

    }
