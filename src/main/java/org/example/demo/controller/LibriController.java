package org.example.demo.controller;

import org.example.demo.model.dto.LibroAggiungiDto;
import org.example.demo.model.dto.LibroDettaglioDto;
import org.example.demo.model.dto.LibroDisponibileDto;
import org.example.demo.model.entity.Libro;
import org.example.demo.service.LibriService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/libri")
public class LibriController {

    @Autowired
    private LibriService libriService;

    @PostMapping(value = "/listaTutti")
    public List<Libro> listaLibri() {
        List<Libro> response = libriService.listaLibri();
        return response;
    }

    // Creo endpoint che, preso id_libro, restituisca il dettaglio del libro e delle sue copie
    @PostMapping(value = "/dettaglioLibro")
    public ResponseEntity<?> dettaglioLibro(@RequestParam Integer idLibro) {
        try {
            LibroDettaglioDto libroRichiesto = libriService.dettaglioLibro(idLibro);
            return new ResponseEntity<>(libroRichiesto, HttpStatus.OK);
        } catch (RuntimeException r) {
            return new ResponseEntity<>(r.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Errore interno del database", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/libriDisponibili")
    public List<LibroDisponibileDto> elencoLibriDisponibili(@RequestParam LocalDate data) {
        return libriService.elencoLibriDisponibilePerData(data);
    }

    @PostMapping(value = "/aggiungiLibro")
    public ResponseEntity<?> aggiungiLibro(@ModelAttribute LibroAggiungiDto libro) /* TODO Rinserire @RequestBody*/ {
        try {
            Libro libroInserito = libriService.aggiungiLibro(libro);
            return new ResponseEntity<>(libroInserito, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/tuttiGeneri")
    public ResponseEntity<?> tuttiGeneri() {
        try {
            List<String> listaGeneri = libriService.listaGeneri();
            return new ResponseEntity<>(listaGeneri, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>("Errore interno del database", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
