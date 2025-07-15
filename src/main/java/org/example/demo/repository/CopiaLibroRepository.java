package org.example.demo.repository;

import org.example.demo.model.dto.LibroMediaPrezzoDto;
import org.example.demo.model.entity.CopiaLibro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CopiaLibroRepository extends JpaRepository<CopiaLibro, Integer> {



    @Query("SELECT new org.example.demo.model.dto.LibroMediaPrezzoDto(l.titolo, AVG(cl.prezzoGiornaliero)) " +
            "FROM CopiaLibro cl " +
            "JOIN cl.libro l " +
            "GROUP BY l.titolo ")
    public List<LibroMediaPrezzoDto> prezzoMedioTitolo();

    @Query("FROM Noleggio n WHERE n.dataFine IS NULL AND n.copiaLibro.idCopiaLibro = :idCopiaLibro")

    public List<CopiaLibro> listaNoleggiNonConclusiByFkCopiaLibro(Integer idCopiaLibro);
}
/*prezzo medio per ogni titolo

select l.titolo, mean(prezzo_titolo)
from copia_libro
join libro on fk_copia_libro = id_libro
group by l.titolo;
 */