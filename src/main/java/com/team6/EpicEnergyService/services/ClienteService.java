package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Cliente;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.ClientiDTO;
import com.team6.EpicEnergyService.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

        Cliente nuovoCliente = new Cliente(
                payload.nomeContatto(),
                payload.cognomeContatto(),
                payload.emailContatto(),
                payload.ragioneSociale(),
                payload.partitaIva()
        );
        return clienteRepository.save(nuovoCliente);
    }

    // cerco il cliente per id
    public Cliente findById(UUID id) {
        Optional<Cliente> cliente = this.clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        } else throw new NotFoundException((id).toString());
    }

    public Page<Cliente> getClienti(int page, int size, String sortBy) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return clienteRepository.findAll(pageable);
    }

    public Cliente update(UUID id, ClientiDTO payload) {

        Cliente cliente = findById(id);

        cliente.setNomeContatto(payload.nomeContatto());
        cliente.setCognomeContatto(payload.cognomeContatto());
        cliente.setEmailContatto(payload.emailContatto());
        cliente.setRagioneSociale(payload.ragioneSociale());
        cliente.setPartitaIva(payload.partitaIva());

        return clienteRepository.save(cliente);
    }

    public void delete(UUID id) {
        Cliente cliente = findById(id);
        clienteRepository.delete(cliente);
    }


    public Cliente uploadLogo(UUID id, MultipartFile file) {
        return null;
    }
}
