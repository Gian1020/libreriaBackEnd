package org.example.demo.service;

import org.example.demo.model.dto.LibroAggiungiDto;
import org.example.demo.model.dto.LibroDettaglioDto;
import org.example.demo.model.dto.LibroDisponibileDto;
import org.example.demo.model.entity.Autore;
import org.example.demo.model.entity.CopiaLibro;
import org.example.demo.model.entity.Libro;
import org.example.demo.repository.AutoriRepository;
import org.example.demo.repository.LibriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LibriService {
    @Autowired
    private LibriRepository libriRepository;

    @Autowired
    private AutoriRepository autoriRepository;

    public List<Libro> listaLibri() {
        List<Libro> response = libriRepository.findAll();
        return response;
    }

    public LibroDettaglioDto dettaglioLibro(Integer idLibro) throws Exception {
        // 1. Recupero il libro tramite ID
        Libro libro = libriRepository.findByIdLibro(idLibro);
        if (libro == null) {
            throw new RuntimeException("Id libro non trovato nel database");
        }

        // 2. Recupero tutte le copie associate al libro
        List<CopiaLibro> copieLibro = libriRepository.findByFkLibro(idLibro);

        // 3. Rimuovo il riferimento al libro per evitare loop ricorsivi (es. in JSON)
        for (CopiaLibro copia : copieLibro) {
            copia.setLibro(null);
        }

        // 4. Creo e ritorno il DTO con le informazioni del libro e delle copie
        LibroDettaglioDto response = new LibroDettaglioDto(libro, copieLibro);
        return response;
    }

    public List<LibroDisponibileDto> elencoLibriDisponibilePerData(LocalDate data) {
        List<Integer> fkCopiaLibroNonDisponibile = libriRepository.trovaFkNonDisponibili(data);
        return libriRepository.elencoLibri(fkCopiaLibroNonDisponibile);

    }

    public Libro aggiungiLibro(LibroAggiungiDto libro) {
        if (libro == null) {
            new Exception("L'oggeto inviato è vuoto");
        }
        Libro libroDaAggiungere = new Libro();
        if (libro.getTitolo() != null && !libro.getTitolo().isEmpty()) {
            libroDaAggiungere.setTitolo(libro.getTitolo());
        }
        if (libro.getGenere() != null && !libro.getGenere().isEmpty()) {
            libroDaAggiungere.setGenere(libro.getGenere());
        }
        if (libro.getAnnoPubblicazione() != null) {
            libroDaAggiungere.setAnnoPubblicazione(libro.getAnnoPubblicazione());
        }

        if (libro.getNomeAutore()!=null && !libro.getNomeAutore().isEmpty()) {
            if (libro.getCognomeAutore()!=null && !libro.getCognomeAutore().isEmpty()){
            Autore autore= autoriRepository.autoreFindByNomeCognome(libro.getNomeAutore(),libro.getCognomeAutore());
            libroDaAggiungere.setAutore(autore);
        }
        else{
            Autore autore = autoriRepository.autoreFindByNome(libro.getNomeAutore());
            libroDaAggiungere.setAutore(autore);
        }
        }
        else{
            libroDaAggiungere.setAutore(null);
        }

        libriRepository.save(libroDaAggiungere);
        return libroDaAggiungere;
    }

    public List<String> listaGeneri() {
        List<String> listaGeneri = libriRepository.listaGeneri();
        return listaGeneri;
    }


}
