package org.example.demo.service;

import org.example.demo.model.dto.LibroClassificaDto;
import org.example.demo.model.dto.NoleggioDto;
import org.example.demo.model.dto.FatturatoMensileDto;
import org.example.demo.model.dto.NoleggioModificaDto;
import org.example.demo.model.entity.Cliente;
import org.example.demo.model.entity.CopiaLibro;
import org.example.demo.model.entity.Noleggio;
import org.example.demo.repository.ClientiRepository;
import org.example.demo.repository.CopiaLibroRepository;
import org.example.demo.repository.NoleggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.example.demo.utility.Utility.dateCoerenti;

@Service
public class NoleggioService {
    @Autowired
    private NoleggioRepository noleggioRepository;

    @Autowired
    private ClientiRepository clienteRepository;

    @Autowired
    private CopiaLibroRepository copiaLibroRepository;

    public String aggiungiNuovoNoleggio(NoleggioDto nuovoNoleggio) throws Exception {
            controlloDataInizio(nuovoNoleggio);
            if (!dateCoerenti(nuovoNoleggio.getDataInizio(), nuovoNoleggio.getDataFine())) {
                throw new Exception("Data non coerente");
            }

            Optional<Cliente> cliente = clienteRepository.findById(nuovoNoleggio.getFkCliente());

            if (cliente.isEmpty()) {
                throw new RuntimeException("Id cliente non trovato");
            }

            List<Noleggio> noleggioNonConclusi = noleggioRepository.trovaNoleggioNonConclusiByFkCopiaLibro(nuovoNoleggio.getFkCopiaLibro());
            if (!noleggioNonConclusi.isEmpty()) {
                throw new Exception("Libro non disponibile");
            }

            Optional<CopiaLibro> copiaLibro = copiaLibroRepository.findById(nuovoNoleggio.getFkCopiaLibro());

            if (copiaLibro.isEmpty()) {
                throw new RuntimeException("Id copia libro non trovato");
            }

            List<Noleggio> noleggiAttivi = noleggioRepository.trovaNoleggiAttiviByFkCliente(nuovoNoleggio.getFkCliente());
            if (!noleggiAttivi.isEmpty()) {
                throw new Exception("Cliente ha già noleggi attivi");
            }

            List<NoleggioDto> elencoNoleggi18m = noleggioRepository.noleggiSconto18mByFkCliente(nuovoNoleggio.getFkCliente());

            if(nuovoNoleggio.getScontoPercentuale()!=0 && elencoNoleggi18m.isEmpty() && nuovoNoleggio.getScontoPercentuale()!=null){
               throw new RuntimeException("Il cliente ha già avuto uno sconto negli ultimi 18 mesi");
            }

            Noleggio noleggioDaInserire = new Noleggio(
                    nuovoNoleggio.getMetodoPagamento(),
                    nuovoNoleggio.getDataInizio(),
                    nuovoNoleggio.getDataFine(),
                    cliente.get(),
                    copiaLibro.get(),
                    nuovoNoleggio.getScontoPercentuale()
            );


            noleggioRepository.save(noleggioDaInserire);

        return "Inserimento cliente andato a buon fine";
    }

    public void controlloDataInizio(NoleggioDto noleggio) {
        if (noleggio.getDataInizio() == null) {
            noleggio.setDataInizio(LocalDate.now());
        }
    }


    public String eliminaNoleggio(Integer idNoleggio) throws Exception {

        Optional<Noleggio> noleggioSelezionato = noleggioRepository.findById(idNoleggio);
        if (noleggioSelezionato.isEmpty()) {
            throw new Exception("L'id corrispondente non è valido") ;
        }
        Noleggio noleggio = noleggioSelezionato.get();
        if (noleggio.getDataFine() == null) {
            throw new Exception("Libro ancora non consegnato impossibile cancellare noleggio");
        }
        noleggioRepository.deleteById(idNoleggio);
        return "Noleggio eliminato";
    }

    public Boolean noleggioNonConclusi(Cliente cliente) {
        List<Noleggio> noleggiAttivi = noleggioRepository.trovaNoleggiAttiviByFkCliente(cliente.getIdCliente());
        if (noleggiAttivi.isEmpty()) {
            return true;
        }
        return false;
    }

    public String modificaNoleggio(NoleggioModificaDto datiNoleggio) throws Exception {
        Optional<Noleggio> optionalNoleggio = noleggioRepository.findById(datiNoleggio.getIdNoleggio());
        if (optionalNoleggio.isEmpty()) {
            throw new Exception("L'id non corrisponde a nessun noleggio");
        }
        Noleggio noleggio = optionalNoleggio.get();
        Boolean dataCoerenti = dateCoerenti(datiNoleggio.getDataInizio(), datiNoleggio.getDataFine());

        if (!dataCoerenti) {
            throw new Exception("Le date non sono coerenti tra di loro");
        }

        if (noleggio.getDataFine() != null) {
            noleggio.setDataFine(datiNoleggio.getDataFine());
        }

        if (noleggio.getDataInizio() != null) {
            noleggio.setDataInizio(datiNoleggio.getDataInizio());
        }

        if (datiNoleggio.getMetodoPagamento() != null && !datiNoleggio.getMetodoPagamento().isEmpty()) {
            noleggio.setMetodoPagamento(datiNoleggio.getMetodoPagamento());
        }

        if (datiNoleggio.getScontoPercentuale() != null) {
            noleggio.setMetodoPagamento(datiNoleggio.getMetodoPagamento());
        }

        // Controlla i noleggi attivi solo se fkCliente è diverso o presente
        if (datiNoleggio.getFkCliente() != null &&
                (noleggio.getCliente() == null ||
                        !datiNoleggio.getFkCliente().equals(noleggio.getCliente().getIdCliente()))) {

            List<Noleggio> noleggiAttivi = noleggioRepository.trovaNoleggiAttiviByFkCliente(datiNoleggio.getFkCliente());
            if (!noleggiAttivi.isEmpty()) {
                throw new Exception("Il cliente ha già noleggi attivi");
            }

            // Controlla che il cliente esista
            Optional<Cliente> optionalCliente = clienteRepository.findById(datiNoleggio.getFkCliente());
            if (optionalCliente.isEmpty()) {
                throw new Exception("Cliente non trovato");
            }
            noleggio.setFkCliente(optionalCliente.get());
        }


        // Controlla i noleggi attivi solo se fkCopiaLibro è diverso o presente
        if (datiNoleggio.getFkCopiaLibro() != null &&
                (noleggio.getCopiaLibro() == null ||
                        !datiNoleggio.getFkCopiaLibro().equals(noleggio.getCopiaLibro().getIdCopiaLibro()))) {

            List<Noleggio> listaLibriNonDisponibili =
                    noleggioRepository.trovaNoleggioNonConclusiByFkCopiaLibro(datiNoleggio.getFkCopiaLibro());

            if (!listaLibriNonDisponibili.isEmpty()) {
                throw new Exception("Libro non disponibile");
            }
            //Controlla che la copia libro sia disponibile
            Optional<CopiaLibro> optionalCopiaLibro = copiaLibroRepository.findById(datiNoleggio.getFkCopiaLibro());
            if (optionalCopiaLibro.isEmpty()) {
                throw new Exception("Copia libro non trovata");
            }
            noleggio.setCopiaLibro(optionalCopiaLibro.get());
        }


        noleggioRepository.save(noleggio);

        return "Cliente modificato";

    }

    public List<LibroClassificaDto> listaClassificaLibri() {
        return noleggioRepository.contaLibriNoleggiati();
    }

    public List<FatturatoMensileDto> fatturatoAnnuo(Integer anno) {

        return noleggioRepository.fatturatoAnnuo(anno);
    }

    public String chiudiNoleggio(Integer idNoleggio) throws Exception {
        Optional<Noleggio> optionalNoleggio =noleggioRepository.findById(idNoleggio);
        if(optionalNoleggio.isEmpty()){
            throw new Exception("Id noleggio non è presente nel database");
        }
        Noleggio noleggioDaChiudere = optionalNoleggio.get();
        if(noleggioDaChiudere.getDataFine()!=null){
            throw new Exception("Il noleggio è già chiuso");
        }
        noleggioDaChiudere.setDataFine(LocalDate.now());
        noleggioRepository.save(noleggioDaChiudere);
        return "Il noleggio "+ idNoleggio +" è stato chiuso";
    }
}


