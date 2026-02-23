package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Comune;
import com.team6.EpicEnergyService.entities.Indirizzo;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.IndirizzoDTO;
import com.team6.EpicEnergyService.repositories.ComuneRepository;
import com.team6.EpicEnergyService.repositories.IndirizzoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class IndirizzoService {
    private final IndirizzoRepository indirizzoRepository;
    private final ComuneRepository comuneRepository;

    @Autowired
    public IndirizzoService(IndirizzoRepository indirizzoRepository, ComuneRepository comuneRepository) {
        this.indirizzoRepository = indirizzoRepository;
        this.comuneRepository = comuneRepository;
    }

    public Indirizzo saveIndirizzo(IndirizzoDTO payload){
        Comune comune = comuneRepository.findById(payload.comuneId()).orElseThrow(() -> new RuntimeException("Comune con ID: " + payload.comuneId() + " non è stato trovato!"));
        Indirizzo indirizzo = new Indirizzo();
        indirizzo.setVia(payload.via());
        indirizzo.setCivico(payload.civico());
        indirizzo.setCap(payload.cap());
        indirizzo.setLocalita(payload.localita());
        indirizzo.setComune(comune);

        Indirizzo savedIndirizzo = indirizzoRepository.save(indirizzo);
        log.info("Nuovo indirizzo salvato con successo: " + savedIndirizzo.getId());
        return savedIndirizzo;
    }

    public Page<Indirizzo> findAll(Pageable pageable) {
        return indirizzoRepository.findAll(pageable);
    }

    public Indirizzo findById(UUID id){
        return indirizzoRepository.findById(id).orElseThrow(() -> new NotFoundException("indirizzo non trovato!"));
    }
}
