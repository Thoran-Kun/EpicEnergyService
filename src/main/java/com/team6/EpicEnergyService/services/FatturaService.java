package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Fattura;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.repositories.FatturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FatturaService {
    private final ClienteRepository clienteRepository;
    private final StatoFatturaRepository statoFatturaRepository;
    private FatturaRepository fatturaRepository;


    @Autowired
    public FatturaService(FatturaRepository fatturaRepository) {
        this.fatturaRepository = fatturaRepository;
    }

    // cerco la fattura per id
    public Fattura findById(UUID id) {
        Optional<Fattura> fattura = this.fatturaRepository.findById(id);
        if (fattura.isPresent()) {
            return fattura.get();
        } else throw new NotFoundException((id).toString());
    }

    
}
