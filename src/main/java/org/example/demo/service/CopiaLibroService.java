package org.example.demo.service;

import org.example.demo.model.dto.LibroMediaPrezzoDto;
import org.example.demo.model.entity.CopiaLibro;
import org.example.demo.repository.CopiaLibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CopiaLibroService {

     @Autowired
    private CopiaLibroRepository copiaLibroRepository;

    public List<LibroMediaPrezzoDto> listaTitoloPrezzoMedio(){
        return copiaLibroRepository.prezzoMedioTitolo();
    }

    public String eliminaCopiaLibro(Integer idCopiaLibro) throws Exception {

        List<CopiaLibro> elencoLibroNonConcolusiByFkCopiaLibro = copiaLibroRepository.listaNoleggiNonConclusiByFkCopiaLibro(idCopiaLibro);

        if (elencoLibroNonConcolusiByFkCopiaLibro.isEmpty()) {
            throw new Exception("La copia libro non puo essere cancellata perche ha un noleggio attivpo");
        }
        Optional<CopiaLibro> optionalCopiaLibroDaCancellare = copiaLibroRepository.findById(idCopiaLibro);
        if (optionalCopiaLibroDaCancellare.isEmpty()) {
            throw new Exception("L'id Copia Libro non è presente nel database");
        }
        CopiaLibro copiaLibroDaCancellare = optionalCopiaLibroDaCancellare.get();
        copiaLibroRepository.delete(copiaLibroDaCancellare);
        return "Eliminazione Copia Libro andata a buon fine";
    }}


