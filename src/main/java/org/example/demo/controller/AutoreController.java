package org.example.demo.controller;

import org.example.demo.model.dto.AutoreDto;
import org.example.demo.service.AutoriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/autore")

public class AutoreController {
    @Autowired
    private AutoriService autoriService;

    @GetMapping("/listaNazAutore")
    public ResponseEntity<?> listaNazAutori(){
        try {
            List<String> listaGeneri = autoriService.listaNazAutori();
            return new ResponseEntity<>(listaGeneri, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Errore interno del database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/aggiungiAutore")
    public ResponseEntity<?> aggiungiAutore (@RequestBody AutoreDto autoreDaInserire){
        try{
            autoriService.aggiungiAutore(autoreDaInserire);
            return new ResponseEntity<>("Inserimento andato a buon fine.", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Errore interno del database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
