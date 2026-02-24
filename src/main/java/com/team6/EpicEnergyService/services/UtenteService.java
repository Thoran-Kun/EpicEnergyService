package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.TipoUtente;
import com.team6.EpicEnergyService.entities.Utente;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.UtentiDTO;
import com.team6.EpicEnergyService.repositories.TipoUtenteRepository;
import com.team6.EpicEnergyService.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UtenteService {

    private final UtenteRepo utenteRepo;
    private final TipoUtenteRepository tipoUtenteRepository;

    @Autowired
    public UtenteService(UtenteRepo utenteRepo, TipoUtenteRepository tipoUtenteRepository) {
        this.utenteRepo = utenteRepo;
        this.tipoUtenteRepository = tipoUtenteRepository;
    }

    public Utente findById(UUID id) {
        return utenteRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public Utente findByEmail(String email) {
        return utenteRepo.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Utente non trovato"));
    }

    public Utente saveUtente(UtentiDTO payload) {
        // TODO: aggiungere controlli su esistenza utente


        TipoUtente tipoUtente = tipoUtenteRepository.findByTipo(payload.tipoUtente())
                .orElseThrow(() -> new RuntimeException("Tipo utente non trovato"));


        Utente nuovoUtente = new Utente(
                payload.username(),
                payload.email(),
                payload.password(),
                payload.nome(),
                payload.cognome()
        );

        // Imposta il TipoUtente
        nuovoUtente.setTipoUtente(tipoUtente);


        return utenteRepo.save(nuovoUtente);
    }
}