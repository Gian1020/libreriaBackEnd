package org.example.demo.controller;

import org.example.demo.model.dto.LibroClassificaDto;
import org.example.demo.model.dto.NoleggioDto;
import org.example.demo.model.dto.FatturatoMensileDto;
import org.example.demo.model.dto.NoleggioModificaDto;
import org.example.demo.service.NoleggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/noleggio")
public class NoleggioController {
    @Autowired
    private NoleggioService noleggioService;

    @PostMapping(value = "/aggiungiNoleggio")
    public String aggiungiNoleggio(@RequestBody NoleggioDto nuovoNoleggio){
        try {
            return noleggioService.aggiungiNuovoNoleggio(nuovoNoleggio);
        }
        catch (Exception e){
            return "Error: "+ e.getMessage();
        }

    }

    @PostMapping(value = "/eliminaNoleggio")
    public String eliminaNoleggio(@RequestParam Integer id){
        try{
            return noleggioService.eliminaNoleggio(id);
        }
        catch (Exception e){
            return "Errore: "+e.getMessage();
        }

    }

    @PostMapping (value="/modificaNoleggio")
    public String modificaNoleggio(@RequestBody NoleggioModificaDto datiNoleggio){
        try{
            return noleggioService.modificaNoleggio(datiNoleggio);
        }
        catch (Exception e){
            return "Errore: "+e.getMessage();
        }

    }

    @PostMapping(value = "/listaClassificaLibri")
    public List<LibroClassificaDto> listaClassificaLibri(){
        return noleggioService.listaClassificaLibri();
    }

    @GetMapping(value= "/fatturato")
    public List<FatturatoMensileDto> fatturatoAnnuo(@RequestParam Integer anno){
        return noleggioService.fatturatoAnnuo(anno);
    }

    @PostMapping(value = "/chiudiNoleggio")
    public String chiudiNoleggio(@RequestParam Integer idNoleggio){
        try{
        return noleggioService.chiudiNoleggio(idNoleggio);}
        catch (Exception e){
            return "Errore "+ e.getMessage();
        }
    }
}
