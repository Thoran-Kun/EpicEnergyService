package com.team6.EpicEnergyService.services;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.team6.EpicEnergyService.entities.Cliente;
import com.team6.EpicEnergyService.entities.Indirizzo;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.ClientiDTO;
import com.team6.EpicEnergyService.payloads.IndirizzoDTO;
import com.team6.EpicEnergyService.repositories.ClienteRepository;
import com.team6.EpicEnergyService.tools.EmailSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@Slf4j
public class ClienteService {
    private final EmailSender mailgun;
    private final Cloudinary cloudinary;
    private ClienteRepository clienteRepository;
    private IndirizzoService indirizzoService;


    @Autowired
    public ClienteService(ClienteRepository clienteRepository, EmailSender mailgun, Cloudinary cloudinary, IndirizzoService indirizzoService) {

        this.clienteRepository = clienteRepository;
        this.mailgun = mailgun;
        this.cloudinary = cloudinary;
        this.indirizzoService = indirizzoService;
    }

    public Cliente save(ClientiDTO payload) {
        IndirizzoDTO indirizzo = new IndirizzoDTO(payload.via(), payload.civico(), payload.localita(), payload.cap(), payload.citta(), payload.tipoSede());
        Indirizzo indirizzo1 = this.indirizzoService.saveIndirizzo(indirizzo);
        Cliente nuovoCliente = new Cliente(
                payload.nomeContatto(),
                payload.cognomeContatto(),
                payload.emailContatto(),
                payload.telefono(),
                payload.ragioneSociale(),
                payload.partitaIva()
        );

        nuovoCliente.setEmail(payload.emailContatto());
        this.mailgun.sendRegistration(nuovoCliente);
        clienteRepository.save(nuovoCliente);
        System.out.println(nuovoCliente.getListaIndirizzi().size());
        this.findByPartitaIva(payload.partitaIva()).getListaIndirizzi().add(indirizzo1);
        return nuovoCliente;
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

    public Cliente findByPartitaIva(String partitaIva) {
        Optional<Cliente> optional = this.clienteRepository.findByPartitaIva(partitaIva);
        if (optional.isPresent()) {
            return optional.get();
        } else throw new NotFoundException("Il cliente non è stato trovato");
    }

    public String uploadLogo(UUID id, MultipartFile file) {
        try {
            Cliente found = this.findById(id);
            Map result = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            String imageUrl = (String) result.get("secure_url");
            found.setLogoAziendale(imageUrl);
            clienteRepository.save(found);

            log.info("Logo aziendale aggiornato per il cliente: " + id);
            return imageUrl;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
