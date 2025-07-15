package org.example.demo.repository;

import org.example.demo.model.dto.LibroClassificaDto;
import org.example.demo.model.dto.FatturatoMensileDto;
import org.example.demo.model.dto.NoleggioDto;
import org.example.demo.model.entity.Noleggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface NoleggioRepository extends JpaRepository<Noleggio, Integer> {
    @Query(value= "FROM Noleggio n WHERE n.copiaLibro.idCopiaLibro = :idCopiaLibro AND n.dataFine is NULL")
    public List<Noleggio> trovaNoleggioNonConclusiByFkCopiaLibro(Integer idCopiaLibro);

    @Query(value = "FROM Noleggio n WHERE n.cliente.idCliente = :idCliente AND dataFine is null")
    public List<Noleggio> trovaNoleggiAttiviByFkCliente(Integer idCliente);

    @Query(value = "FROM Noleggio n WHERE n.cliente.idCliente = :idCliente")
    public List<Noleggio> fkClienteInNoleggio(Integer idCliente);

    @Query(value = "SELECT new org.example.demo.model.dto.LibroClassificaDto(l.titolo, count(n)) " +
            "FROM Noleggio n " +
            "JOIN n.copiaLibro cl " +
            "JOIN cl.libro l " +
            "GROUP BY l.titolo " +
            "ORDER BY count(n) DESC " )
    public List<LibroClassificaDto> contaLibriNoleggiati();



    @Query("SELECT new org.example.demo.model.dto.FatturatoMensileDto(" +
            "MONTH(n.dataInizio), " +
            "SUM(DATEDIFF(n.dataFine, n.dataInizio) * c.prezzoGiornaliero), " +
            "SUM(DATEDIFF(n.dataFine, n.dataInizio) * c.prezzoGiornaliero * (1 - n.scontoPercentuale / 100)) ) " +
            "FROM Noleggio n " +
            "JOIN n.copiaLibro c " +
            "WHERE YEAR(n.dataInizio) = :anno " +
            "GROUP BY MONTH(n.dataInizio) " +
            "ORDER BY MONTH(n.dataInizio)")
    public  List<FatturatoMensileDto> fatturatoAnnuo(Integer anno);

    @Query ("FROM Noleggio n " +
            "WHERE n.scontoPercentuale!=0 AND DATEDIFF(CURDATE(), n.dataInizio)>= 558 AND n.cliente.idCliente = :fkCliente")

    List<NoleggioDto> noleggiSconto18mByFkCliente (Integer fkCliente);
}

