package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Cliente;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.ClientiDTO;
import com.team6.EpicEnergyService.payloads.IndirizzoDTO;
import com.team6.EpicEnergyService.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {
    private ClienteRepository clienteRepository;
    private IndirizzoService indirizzoService;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository, IndirizzoService indirizzoService) {
        this.clienteRepository = clienteRepository;
        this.indirizzoService = indirizzoService;
    }

    public Cliente save(ClientiDTO payload) {
        IndirizzoDTO indirizzo = new IndirizzoDTO(payload.via(), payload.civico(), payload.localita(), payload.cap(), payload.citta());
        this.indirizzoService.saveIndirizzo(indirizzo);
        Cliente nuovoCliente = new Cliente(
                payload.nomeContatto(),
                payload.cognomeContatto(),
                payload.emailContatto(),
                payload.ragioneSociale(),
                payload.partitaIva(),
                this.indirizzoService.findByVia(payload.via())
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

}
