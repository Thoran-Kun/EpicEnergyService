package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Cliente;
import com.team6.EpicEnergyService.payloads.ClientiDTO;
import com.team6.EpicEnergyService.repositories.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    private ClienteRepo clienteRepo;

    @Autowired
    public ClienteService(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public Cliente save(ClientiDTO payload) {
        //TODO: controlli sull'esistenza del cliente
        Cliente nuovoCliente = new Cliente(payload.nomeContatto(), payload.cognomeContatto(), payload.emailContatto(), payload.ragioneSociale(), payload.partitaIva());
        this.clienteRepo.save(nuovoCliente);
        return nuovoCliente;
    }
}
