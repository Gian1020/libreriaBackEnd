package org.example.demo.repository;

import org.example.demo.model.entity.Autore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface AutoriRepository extends JpaRepository<Autore, Integer> {

}
