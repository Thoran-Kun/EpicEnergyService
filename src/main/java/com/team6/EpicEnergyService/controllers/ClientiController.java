package com.team6.EpicEnergyService.controllers;

import com.team6.EpicEnergyService.entities.Cliente;
import com.team6.EpicEnergyService.entities.Utente;
import com.team6.EpicEnergyService.exceptions.BadRequestException;
import com.team6.EpicEnergyService.payloads.ClientiDTO;
import com.team6.EpicEnergyService.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clienti")
public class ClientiController {

    @Autowired
    private ClienteService clienteService;


    // CREATE CLIENTE

    @PostMapping("")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente saveCliente(
            @RequestBody @Validated ClientiDTO body,
            BindingResult validation,
            @AuthenticationPrincipal Utente utente
    ) {

        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }

        return clienteService.save(body);
    }

    // GET BY ID

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Cliente getCliente(@PathVariable UUID id) {
        return clienteService.findById(id);
    }


    // GET ALL

    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ADMIN','USER')")
    public Page<Cliente> getClienti(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id_cliente") String sortBy
    ) {
        return clienteService.getClienti(page, size, sortBy);
    }


    // UPDATE
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Cliente updateCliente(
            @PathVariable UUID id,
            @RequestBody @Validated ClientiDTO body,
            BindingResult validation
    ) {

        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }

        return clienteService.update(id, body);
    }


    // DELETE CLIENTE
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCliente(@PathVariable UUID id) {
        clienteService.delete(id);
    }


    // ORDINAMENTI

    @GetMapping("/order/cognome")
    public List<Cliente> ordinaPerCognomeParziale() {
        return clienteService.orderByCognome();
    }

    @GetMapping("/order/fatturato")
    public List<Cliente> ordinaPerFatturato() {
        return clienteService.orderByFatturato();
    }

    @GetMapping("/order/data-inserimento")
    public List<Cliente> ordinaPerDataInserimento() {
        return clienteService.orderByDataInserimento();
    }

    @GetMapping("/order/ultimo-contatto")
    public List<Cliente> ordinaPerUltimoContatto() {
        return clienteService.orderByUltimoContatto();
    }

    // FILTRI

    // Filtro i clienti per fatturato
    @GetMapping("/filter/fatturato")
    public List<Cliente> filtraPerFatturato(@RequestParam double fatturato) {
        return clienteService.filterByFatturato(fatturato);
    }

    // Filtro i clienti per la data di inserimento
    @GetMapping("/filter/data-inserimento")
    public List<Cliente> filtraPerDataInserimento(@RequestParam LocalDate data) {
        return clienteService.filterByData(data);
    }

    // Filtro i clienti per la data dell'ultimo contatto
    @GetMapping("/filter/ultimo-contatto")
    public List<Cliente> filtraPerUltimoContatto(@RequestParam LocalDate data) {
        return clienteService.filterByContatto(data);
    }

    // Filtro i clienti per cognome parziale
    @GetMapping("/filter/cognome")
    public List<Cliente> filtraPerCognome(@RequestParam String cognome) {
        return clienteService.filterByCognome(cognome);
    }


}