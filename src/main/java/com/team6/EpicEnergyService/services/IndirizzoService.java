package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Comune;
import com.team6.EpicEnergyService.entities.Indirizzo;
import com.team6.EpicEnergyService.payload.IndirizzoDTO;
import com.team6.EpicEnergyService.repositories.IndirizzoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class IndirizzoService {
    private final IndirizzoRepository indirizzoRepository;

    @Autowired
    public IndirizzoService(IndirizzoRepository indirizzoRepository) {
        this.indirizzoRepository = indirizzoRepository;
    }

//    public Indirizzo saveIndirizzo(IndirizzoDTO payload){
//        Comune comune = comuneRepository.findById(payload.comuneId()).orElseThrow(() -> new )
//    }
//}
