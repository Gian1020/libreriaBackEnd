package org.example.demo.service;

import org.example.demo.model.dto.CasaEditriceDto;
import org.example.demo.model.entity.CasaEditrice;
import org.example.demo.repository.CasaEditriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CasaEditriceService {
    @Autowired
    private CasaEditriceRepository casaEditriceRepository;

   public CasaEditriceDto CasaEditriceDettaglio(Integer idCasaEditrice) throws Exception {
       CasaEditrice casaEditrice= casaEditriceRepository.findByIdCasaEditrice(idCasaEditrice);
       if(casaEditrice==null){
           throw new Exception( "Id casa editrice non presente nel Database");
       }
       return new CasaEditriceDto(
               "Rischiesta andata a buon fine",
               casaEditrice.getNome(),
               casaEditrice.getCodiceFiscale(),
               casaEditrice.getSedeCitta()
       );
   }
}
