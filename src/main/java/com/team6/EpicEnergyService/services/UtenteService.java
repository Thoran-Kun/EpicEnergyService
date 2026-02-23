package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.repositories.UtenteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtenteService {
    private UtenteRepo utenteRepo;

    @Autowired
    public UtenteService(UtenteRepo utenteRepo) {
        this.utenteRepo = utenteRepo;
    }
}
