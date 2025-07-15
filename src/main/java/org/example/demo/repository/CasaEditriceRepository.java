package org.example.demo.repository;

import org.example.demo.model.entity.CasaEditrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CasaEditriceRepository extends JpaRepository<CasaEditrice, Integer> {

    @Query("FROM CasaEditrice ce WHERE idCasaEditrice = :idCasaEditrice ")

    CasaEditrice findByIdCasaEditrice(Integer idCasaEditrice);
}
