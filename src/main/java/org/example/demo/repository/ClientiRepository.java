package org.example.demo.repository;

import org.example.demo.model.dto.ClienteDaSgridareDto;
import org.example.demo.model.dto.ClienteStoricoNoleggiDto;
import org.example.demo.model.entity.Cliente;
import org.example.demo.model.entity.Noleggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface ClientiRepository extends JpaRepository<Cliente, Integer> {

    @Query("FROM Cliente c WHERE c.idCliente = :id")
    Cliente findByIdCliente(Integer id);

    /*@Query(value = "SELECT new com.example.demo.model.dto.ClienteDaSgridareDTO(c.nome, c.cognome, c.email, l.titolo, n.dataInizio) " +
            "FROM Noleggio n " +
            "JOIN n.cliente c " +
            "JOIN n.copiaLibro cl " +
            "JOIN cl.libro l " +
            "WHERE " +
            "n.dataFine IS NULL AND " +
            "n.dataInizio < :dataLimite")*/

    @Query("SELECT new org.example.demo.model.dto.ClienteDaSgridareDto(c.nome, c.cognome, c.email, l.titolo, n.dataInizio) " +
            "FROM " +
            "Cliente c " +
            "JOIN Noleggio n ON n.cliente.idCliente = c.idCliente " +
            "JOIN CopiaLibro cl ON  n.copiaLibro.idCopiaLibro = cl.idCopiaLibro " +
            "JOIN Libro l ON l.idLibro = cl.libro.idLibro " +
            "WHERE " +
            "n.dataFine IS NULL AND " +
            "n.dataInizio < :dataLimite ")


    public List<ClienteDaSgridareDto> elencaRitardatari(LocalDate dataLimite);

    @Query("SELECT new org.example.demo.model.dto.ClienteStoricoNoleggiDto(l.titolo, a.nome, a.cognome, n.dataInizio, n.dataFine, cl.prezzoGiornaliero, n.scontoPercentuale) " +
            "FROM Noleggio n " +
            "JOIN n.copiaLibro cl " +
            "JOIN cl.libro l " +
            "JOIN l.autore a " +
            "WHERE n.cliente.idCliente = :idCliente ")
    List<ClienteStoricoNoleggiDto> elencoStoricoClienti(@Param("idCliente") Integer idCliente);



}
