package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinciaService {
    private ComuneService comuneService;
    private ProvinciaRepository provinciaRepository;

    @Autowired
    public ProvinciaService(ProvinciaRepository provinciaRepository, ComuneService comuneService) {
        this.provinciaRepository = provinciaRepository;
        this.comuneService = comuneService;
    }
}
