package org.example.demo.controller;

import org.example.demo.model.dto.ClienteDto;
import org.example.demo.model.dto.ClienteModificaDto;
import org.example.demo.model.dto.ClienteDaSgridareDto;
import org.example.demo.model.dto.ClienteStoricoNoleggiDto;
import org.example.demo.model.entity.Cliente;
import org.example.demo.service.ClientiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/clienti")
public class ClientiController {
    @Autowired
    private ClientiService clientiService;

    @GetMapping(value = "/listaTutti")
    public List<Cliente> listaClienti() {
        return clientiService.listaTutti();
    }

    @PostMapping(value= "/nuovoCliente")
    public String aggiungiCliente(@RequestBody ClienteDto nuovoCliente){
        return clientiService.aggiungiNuovoCliente(nuovoCliente);
    }

    @PostMapping(value= "/modificaCliente")
    public String modificaCliente(@RequestBody ClienteModificaDto datiCliente){
        try{
            return clientiService.modificaCliente(datiCliente);
        }
        catch (Exception e){
            return "Errore" + e.getMessage();
        }

    }

    @PostMapping(value= "/eliminaCliente")
    public String eliminaCliente(@RequestParam Integer idCliente){
       //Se il server non genera errore viene eseguito il blocco dentro try
       try {
           return clientiService.eliminaCliente(idCliente);
       }
       //Se genererà errore Il throw (presente nel service) entrerà direttamente nel catch
       // facendo tornare il messaggio d errore personalizzato
        catch (Exception e){
           return "Errore" + e.getMessage();
        }
    }

    @PostMapping(value= "/ritardatari")
    public List<ClienteDaSgridareDto> elencoClientiRitardatati(@RequestParam Integer periodoRitardo){
        return clientiService.listaRitardatari(periodoRitardo);
    }

    @PostMapping(value = "/storicoNoleggi")
    public List<ClienteStoricoNoleggiDto> storicoNoleggio(@RequestParam Integer idCliente){
        return clientiService.storicoNoleggio(idCliente);
    }
}

