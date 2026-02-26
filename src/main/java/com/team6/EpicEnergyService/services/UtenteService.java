package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.EnumTipoUtente;
import com.team6.EpicEnergyService.entities.TipoUtente;
import com.team6.EpicEnergyService.entities.Utente;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.UtentiDTO;
import com.team6.EpicEnergyService.repositories.TipoUtenteRepository;
import com.team6.EpicEnergyService.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class UtenteService {

    private final UtenteRepo utenteRepo;
    private final TipoUtenteRepository tipoUtenteRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UtenteService(UtenteRepo utenteRepo, TipoUtenteRepository tipoUtenteRepository, PasswordEncoder passwordEncoder) {
        this.utenteRepo = utenteRepo;
        this.tipoUtenteRepository = tipoUtenteRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public Utente findById(UUID id) {
        return utenteRepo.findById(id)
                .orElseThrow(() -> new NotFoundException(id));
    }

    public TipoUtente findByTipo(String tipo) {
        return tipoUtenteRepository.findByTipo(EnumTipoUtente.valueOf(tipo)).orElseThrow(() -> new NotFoundException(tipo));
    }

    public Utente findByEmail(String email) {
        return utenteRepo.findByEmail(email)
                .orElseThrow(() -> new NotFoundException("Utente non trovato"));
    }

    public Utente saveUtente(UtentiDTO payload) {
        // TODO: aggiungere controlli su esistenza utente

        TipoUtente tipo = this.findByTipo(payload.tipo());

        Utente nuovoUtente = new Utente(
                payload.username(),
                payload.email(),
                passwordEncoder.encode(payload.password()),
                payload.nome(),
                payload.cognome(),
                tipo
        );

        return utenteRepo.save(nuovoUtente);
    }


}