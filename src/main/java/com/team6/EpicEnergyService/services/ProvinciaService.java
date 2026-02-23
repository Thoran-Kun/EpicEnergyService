package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Comune;
import com.team6.EpicEnergyService.entities.Provincia;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.ProvinciaDTO;
import com.team6.EpicEnergyService.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProvinciaService {
    private ComuneService comuneService;
    private ProvinciaRepository provinciaRepository;

    @Autowired
    public ProvinciaService(ProvinciaRepository provinciaRepository, ComuneService comuneService) {
        this.provinciaRepository = provinciaRepository;
        this.comuneService = comuneService;
    }

    public Provincia save(ProvinciaDTO payload) {
        Comune comune = this.comuneService.findById(payload.id_comune());
        Provincia provincia = new Provincia(payload.nome(), payload.sigla(), comune);
        this.provinciaRepository.save(provincia);
        return provincia;
    }

    public Provincia findById(UUID uuid) {
        Optional<Provincia> optional = this.provinciaRepository.findById(uuid);
        if (optional.isPresent()) return optional.get();
        else throw new NotFoundException(uuid);
    }
}
