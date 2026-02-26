package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Comune;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.repositories.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ComuneService {
    @Autowired
    private ComuneRepository comuneRepository;

    @Autowired
    private ProvinciaService provinciaService;

    public Comune save(Comune comune) {
        Comune comune1 = new Comune(comune.getNome(), comune.getProvincia());
        comuneRepository.save(comune1);
        return comune1;
    }

    public Comune findById(UUID id) {
        return comuneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comune non trovato"));
    }

    public Comune findByNome(String comune) {
        Optional<Comune> optional = this.comuneRepository.findByNome(comune);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NotFoundException("Comune non trovato");
        }
    }
}