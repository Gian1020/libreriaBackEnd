package org.example.demo.repository;

import org.example.demo.model.dto.LibroDisponibileDto;
import org.example.demo.model.entity.CopiaLibro;
import org.example.demo.model.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LibriRepository extends JpaRepository<Libro, Integer> {

    @Query(" FROM " +
            " CopiaLibro cl " +
            " where " +
            " cl.libro.idLibro = :idLibro")
    public List<CopiaLibro> findByFkLibro(@Param("idLibro") Integer idLibro);

    @Query( "SELECT new org.example.demo.model.dto.LibroDisponibileDto(cl.idCopiaLibro, l.titolo, a.nome, a.cognome, l.genere, cl.prezzoGiornaliero, c.nome) " +
            "FROM CopiaLibro cl " +
            "JOIN cl.libro l " +
            "JOIN cl.casaEditrice c " +
            "JOIN l.autore a " +
            "WHERE cl.idCopiaLibro NOT IN :elencoNonDisponibili")

    public List<LibroDisponibileDto> elencoLibri(List<Integer> elencoNonDisponibili);

   @Query("SELECT DISTINCT n.copiaLibro.idCopiaLibro FROM Noleggio n " +
           "WHERE n.dataInizio <= :data AND (n.dataFine IS NOT NULL OR n.dataFine >= :data)")
    public List<Integer> trovaFkNonDisponibili(@RequestParam LocalDate data);

   @Query("FROM Libro l WHERE l.idLibro = :idLibro")

    Libro findByIdLibro(Integer idLibro);


    @Query("SELECT DISTINCT l.genere FROM Libro l WHERE l.genere IS NOT NULL")
    List<String> listaGeneri();

    @Query("SELECT DISTINCT l.autore.nazionalita FROM Libro l WHERE l.autore.nazionalita IS NOT NULL")
    List<String> listaNazAutori();
}



