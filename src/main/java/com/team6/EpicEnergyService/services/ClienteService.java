package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Cliente;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.ClientiDTO;
import com.team6.EpicEnergyService.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente save(ClientiDTO payload) {
        //TODO: controlli sull'esistenza del cliente
        Cliente nuovoCliente = new Cliente(payload.nomeContatto(), payload.cognomeContatto(), payload.emailContatto(), payload.ragioneSociale(), payload.partitaIva());
        this.clienteRepository.save(nuovoCliente);
        return nuovoCliente;
    }

    // cerco il cliente per id
    public Cliente findById(UUID id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        } else throw new NotFoundException((id).toString());
    }
}
