package org.example.demo.service;

import org.example.demo.model.dto.ClienteDto;
import org.example.demo.model.dto.ClienteModificaDto;
import org.example.demo.model.dto.ClienteDaSgridareDto;
import org.example.demo.model.dto.ClienteStoricoNoleggiDto;
import org.example.demo.model.entity.Cliente;
import org.example.demo.model.entity.Noleggio;
import org.example.demo.repository.ClientiRepository;
import org.example.demo.repository.NoleggioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Service
public class ClientiService {
    @Autowired
    private NoleggioService noleggioService;

    @Autowired
    private NoleggioRepository noleggioRepository;

    @Autowired
    private ClientiRepository clientiRepository;

    public List<Cliente> listaTutti() {
        List<Cliente> response = clientiRepository.findAll();
        return response;
    }

    public String aggiungiNuovoCliente (ClienteDto nuovoCliente){
        Cliente clienteDaInserire = new Cliente ();
        BeanUtils.copyProperties(nuovoCliente, clienteDaInserire);

        clientiRepository.save(clienteDaInserire);
        return "Inserimento andato a buon fine";
    }

    public String modificaCliente (ClienteModificaDto datiCliente) throws Exception {
        //Individua il cliente da modificare con id
        Cliente cliente= clientiRepository.findByIdCliente(datiCliente.getId());
        //Controlliamo se l id è presente nella tabella
        if(cliente==null){
            throw new Exception("L'id cliente non corrisponde a nessun cliente");
        }

        //Modifichiamo l'entity controllando se l'utente ha inserito il valore da sostituire nel CLienteModificaDto sennò lascio il campo invariato
        if(!cliente.getNome().isEmpty() && cliente.getNome()!=(null)){
           cliente.setNome(datiCliente.getNome());
        }
        if(!cliente.getCognome().isEmpty() && cliente.getCognome()!=(null)){
           cliente.setCognome(datiCliente.getCognome());
        }
        if(cliente.getDataNascita()!=(null)){
           cliente.setDataNascita(datiCliente.getDataNascita());
        }
        if(!cliente.getEmail().isEmpty() && cliente.getNome()!=(null)){
           cliente.setEmail(datiCliente.getEmail());
        }
        if(!cliente.getNome().isEmpty() && cliente.getNome()!=(null)){
            cliente.setNumeroCartaCredito(datiCliente.getNumeroCartaCredito());
        }

        //Salviamo le modifiche
        clientiRepository.save(cliente);
        return "Modifica avvenuta con successo";
    }

    public String eliminaCliente(Integer idCliente) throws Exception {
        //Individua il cliente da modificare con id
        Cliente cliente= clientiRepository.findByIdCliente(idCliente);
        //Controlliamo se l id è presente nella tabella
        if(cliente==null){
            throw new Exception("L'id non corrisponde a nessun utente");
        }

        List<Noleggio> noleggioChehafkCliente = noleggioRepository.fkClienteInNoleggio(idCliente);
        Boolean clienteHaNolAttivi = noleggioService.noleggioNonConclusi(cliente);
        //Controllo se il CLiente ha noleggi attivi
        if(clienteHaNolAttivi){
            throw new Exception("Il cliente deve riportare un libro");
        }
        //Controllo se il Cliente ha un noleggio non attivo presente nella tabella
        if(!noleggioChehafkCliente.isEmpty()){
            //Setto a null fkCliente in noleggio per togliere la relazione tra Noleggio e CLiente in questa tabella
            for(Noleggio noleggio : noleggioChehafkCliente) {
                noleggio.setFkCliente(null);
            }
        }
        //Elimino il cliente
        clientiRepository.deleteById(idCliente);
        return "Eliminazione andata a buon fine";
    }

    public List<ClienteDaSgridareDto> listaRitardatari(Integer periodoRitardo) {
        // Ottiene l'istanza attuale del calendario (cioè la data e ora corrente)
        Calendar calendar = Calendar.getInstance();

        // Sottrae "periodoRitardo" giorni dalla data corrente
        calendar.add(Calendar.DAY_OF_MONTH, -1*periodoRitardo);

        // Converte il valore ottenuto da Calendar in un oggetto LocalDate
        LocalDate dataLimite = calendar.toInstant()
                .atZone(calendar.getTimeZone().toZoneId())
                .toLocalDate();
        return clientiRepository.elencaRitardatari(dataLimite);
    }

    public List<ClienteStoricoNoleggiDto> storicoNoleggio(Integer idCliente) {
       return clientiRepository.elencoStoricoClienti(idCliente);
    }


}