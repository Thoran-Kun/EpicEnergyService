package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.TipoUtente;
import com.team6.EpicEnergyService.repositories.TipoUtenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoUtenteService {
    @Autowired
    private TipoUtenteRepository tipoUtenteRepository;

    public TipoUtente save(TipoUtente tipo) {
        this.tipoUtenteRepository.save(tipo);
        return tipo;
    }

}
