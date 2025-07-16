package org.example.demo.service;

import org.example.demo.model.dto.AutoreDto;
import org.example.demo.model.entity.Autore;
import org.example.demo.repository.AutoriRepository;
import org.example.demo.repository.LibriRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static org.example.demo.utility.Utility.dateCoerenti;

@Service
public class AutoriService {
    @Autowired
    private LibriRepository libriRepository;
    @Autowired
    private AutoriRepository autoriRepository;

    public List<String> listaNazAutori() {
        List<String> listaNazAutori = libriRepository.listaNazAutori();
        return listaNazAutori;
    }

    public void aggiungiAutore(AutoreDto autoreDaInserire) {
        if(autoreDaInserire!=null){
            Autore autoreDaSalvare = new Autore();
            if(autoreDaInserire.getNome()!=null && !autoreDaInserire.getNome().isEmpty()){
                autoreDaSalvare.setNome(autoreDaInserire.getNome());
            }
            if (autoreDaInserire.getCognome()!=null && !autoreDaInserire.getCognome().isEmpty()){
                autoreDaSalvare.setCognome(autoreDaInserire.getCognome());
            }
            if (autoreDaInserire.getDataNascita()!=null){
                autoreDaSalvare.setDataNascita(autoreDaInserire.getDataNascita());
                if(autoreDaInserire.getDataMorte()!=null && dateCoerenti(autoreDaInserire.getDataNascita(), autoreDaInserire.getDataMorte())){
                    autoreDaSalvare.setDataMorte(autoreDaInserire.getDataMorte());
                } else autoreDaSalvare.setDataMorte(null);
            }
            else {
                autoreDaSalvare.setDataNascita(null);
            }
            if(autoreDaInserire.getNazionalita()!=null && !autoreDaInserire.getNazionalita().isEmpty()){
                autoreDaSalvare.setNazionalita(autoreDaInserire.getNazionalita());
            }
            autoriRepository.save(autoreDaSalvare);
        }
        else {
            throw new RuntimeException("L'oggetto da inserire è NULL.");
        }
    }
}
