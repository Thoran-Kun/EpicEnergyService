package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.repositories.ClienteRepo;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepo clienteRepo;

    @Override
    public ClienteService(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }
}
