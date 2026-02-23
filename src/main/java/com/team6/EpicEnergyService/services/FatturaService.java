package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Cliente;
import com.team6.EpicEnergyService.entities.Fattura;
import com.team6.EpicEnergyService.entities.StatoFattura;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.FattureDTO;
import com.team6.EpicEnergyService.repositories.FatturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Fattura nuovaFattura = new Fattura(payload.importo(), cliente, stato);
        return fatturaRepository.save(nuovaFattura);

    }

}