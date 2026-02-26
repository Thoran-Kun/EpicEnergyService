package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Indirizzo;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.IndirizzoDTO;
import com.team6.EpicEnergyService.repositories.IndirizzoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class IndirizzoService {
    private final IndirizzoRepository indirizzoRepository;
    private final ComuneService comuneService;

    @Autowired
    public IndirizzoService(IndirizzoRepository indirizzoRepository, ComuneService comuneService) {
        this.indirizzoRepository = indirizzoRepository;
        this.comuneService = comuneService;
    }

    public Indirizzo saveIndirizzo(IndirizzoDTO payload) {
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setVia(payload.via());
        indirizzo.setCivico(payload.civico());
        indirizzo.setCap(payload.cap());
        indirizzo.setLocalita(payload.localita());
        indirizzo.setComune(comuneService.findByNome(payload.citta()));

        Indirizzo savedIndirizzo = indirizzoRepository.save(indirizzo);
        log.info("Nuovo indirizzo salvato con successo: " + savedIndirizzo.getId());
        return savedIndirizzo;
    }

    public Page<Indirizzo> findAll(Pageable pageable) {
        return indirizzoRepository.findAll(pageable);
    }

    public Indirizzo findById(UUID id) {
        return indirizzoRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public Indirizzo findByVia(String via) {
        Optional<Indirizzo> optional = this.indirizzoRepository.findByVia(via);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new NotFoundException("Indirizzo non trovato");
    }
}
