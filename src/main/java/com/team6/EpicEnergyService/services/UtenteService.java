package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Utente;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.UtentiDTO;
import com.team6.EpicEnergyService.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UtenteService {
    private UtenteRepo utenteRepo;

    @Autowired
    public UtenteService(UtenteRepo utenteRepo) {
        this.utenteRepo = utenteRepo;
    }

    public Utente findById(UUID id) {
        Optional<Utente> optional = this.utenteRepo.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new NotFoundException((id));
    }

    public Utente saveUtente(UtentiDTO payload) {
        //TODO: aggiungere controlli su esistenza utente
        Utente nuovoUtente = new Utente(payload.username(), payload.email(), payload.password(), payload.nome(), payload.cognome(), payload.tipoUtente());
        this.utenteRepo.save(nuovoUtente);
        return nuovoUtente;
    }
}
