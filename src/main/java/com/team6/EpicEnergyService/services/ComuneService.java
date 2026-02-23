package com.team6.EpicEnergyService.services;

import java.util.UUID;

import com.team6.EpicEnergyService.entities.Comune;
import com.team6.EpicEnergyService.entities.Provincia;
import com.team6.EpicEnergyService.payloads.ComuneDTO;
import com.team6.EpicEnergyService.repositories.ComuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ComuneService {
    @Autowired
    private ComuneRepository comuneRepository;

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public Comune save(ComuneDTO dto) {

        Provincia provincia = provinciaRepository.findById(dto.provinciaId())
                .orElseThrow(() -> new RuntimeException("Provincia non trovata"));

        Comune comune = new Comune();

        comune.setNome(dto.nome());
        comune.setProvincia(provincia);

        return comuneRepository.save(comune);
    }

    public Comune findById(UUID id) {
        return comuneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comune non trovato"));
    }
}

}