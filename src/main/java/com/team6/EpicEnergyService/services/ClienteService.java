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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

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

    // ORDINAMENTO DEI CLIENTI
    public List<Cliente> orderByCognome() {
        return clienteRepository.findAllByOrderByNomeContattoAsc();
    }

    public List<Cliente> orderByFatturato() {
        return clienteRepository.findAllByOrderByFatturatoAnnualeAsc();
    }

    public List<Cliente> orderByDataInserimento() {
        return clienteRepository.findAllByOrderByDataInserimentoAsc();
    }

    public List<Cliente> orderByUltimoContatto() {
        return clienteRepository.findAllByOrderByDataUltimoContattoAsc();
    }

    // FILTRO DEI CLIENTI
    public List<Cliente> filterByFatturato(double fatturato) {
        return clienteRepository.findByFatturatoAnnuale(fatturato);
    }

    public List<Cliente> filterByData(LocalDate data) {
        return clienteRepository.findByDataInserimento(data);
    }

    public List<Cliente> filterByContatto(LocalDate data) {
        return clienteRepository.findByDataUltimoContatto(data);
    }

    public List<Cliente> filterByCognome(String cognomeParziale) {
        return clienteRepository.findByCognomeContattoContainingIgnoreCase(cognomeParziale);
    }

}
