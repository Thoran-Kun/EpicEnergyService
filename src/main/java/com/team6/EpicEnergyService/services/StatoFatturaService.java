package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.EnumStatoFattura;
import com.team6.EpicEnergyService.entities.StatoFattura;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.repositories.StatoFatturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class StatoFatturaService {

    private final StatoFatturaRepository statoFatturaRepository;

    @Autowired
    public StatoFatturaService(StatoFatturaRepository statoFatturaRepository) {
        this.statoFatturaRepository = statoFatturaRepository;
    }

    // cerco lo stato per id
    public StatoFattura findById(UUID id) {
        return statoFatturaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(id.toString()));
    }

    // Recupero l'enum dello stato tramite l'id
    public StatoFattura findByStato(EnumStatoFattura stato) {
        return statoFatturaRepository.findByStato(stato)
                .orElseThrow(() -> new NotFoundException("Stato " + stato + " non trovato"));
    }

}
