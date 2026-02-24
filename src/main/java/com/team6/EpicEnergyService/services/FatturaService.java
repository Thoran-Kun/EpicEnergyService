package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Cliente;
import com.team6.EpicEnergyService.entities.EnumStatoFattura;
import com.team6.EpicEnergyService.entities.Fattura;
import com.team6.EpicEnergyService.entities.StatoFattura;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.FattureDTO;
import com.team6.EpicEnergyService.repositories.FatturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FatturaService {

    private final StatoFatturaService statoFatturaService;
    private FatturaRepository fatturaRepository;
    private ClienteService clienteService;


    @Autowired
    public FatturaService(FatturaRepository fatturaRepository, ClienteService clienteService,
                          StatoFatturaService statoFatturaService
    ) {
        this.fatturaRepository = fatturaRepository;
        this.clienteService = clienteService;
        this.statoFatturaService = statoFatturaService;
    }

    // cerco la fattura per id
    public Fattura findById(UUID id) {
        return fatturaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));
    }

    // salvo la fattura
    public Fattura save(FattureDTO payload) {

        // recupero l'id del cliente
        Cliente cliente = clienteService.findById(payload.clienteId());

        // recupero lo stato (enum) della fattura tramite il suo id
        StatoFattura stato = statoFatturaService.findByStato(payload.stato());

        // creo la nuova fattura
        Fattura nuovaFattura = new Fattura(payload.importo(), cliente, stato);

        // incremento il numero di fattura
        int nextNumero = (int) fatturaRepository.count() + 1;
        nuovaFattura.setNumero(nextNumero);


        return fatturaRepository.save(nuovaFattura);

    }

    // modifico la fattura (solo stato)
    public Fattura updateStato(UUID fatturaId, EnumStatoFattura nuovoStato) {
        // prendo la fattura tramite id
        Fattura fattura = this.findById(fatturaId);

        // prendo lo stato della fattura
        StatoFattura stato = statoFatturaService.findByStato(nuovoStato);

        // modifico lo stato
        fattura.setStatoFattura(stato);

        // la salvo
        return fatturaRepository.save(fattura);
    }


    // modifico la fattura (campi importo e stato)
    public Fattura updateFattura(UUID fatturaId, FattureDTO body, EnumStatoFattura nuovoStato) {
        // prendo la fattura
        Fattura fattura = this.findById(fatturaId);
        // prendo lo stato della fattura
        StatoFattura stato = statoFatturaService.findByStato(nuovoStato);
        // modifico lo stato
        fattura.setStatoFattura(stato);
        // modifico l'importo
        fattura.setImporto(body.importo());
        // la salvo
        return fatturaRepository.save(fattura);
    }

    // elimino la fattura per id
    public void findByIdAndDelete(UUID fatturaId) {
        Fattura fatturaDaEliminare = this.findById(fatturaId);
        fatturaRepository.delete(fatturaDaEliminare);
    }

    // prendo le fatture per anno
    public List<Fattura> findByYear(int anno) {
        return fatturaRepository.findByYear(anno);
    }

}