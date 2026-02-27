package com.team6.EpicEnergyService.controllers;

import com.team6.EpicEnergyService.entities.EnumStatoFattura;
import com.team6.EpicEnergyService.entities.Fattura;
import com.team6.EpicEnergyService.entities.Utente;
import com.team6.EpicEnergyService.exceptions.BadRequestException;
import com.team6.EpicEnergyService.payloads.FattureDTO;
import com.team6.EpicEnergyService.services.FatturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
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
@RequestMapping("/fatture")
public class FattureController {
    @Autowired
    FatturaService fatturaService;

    // POST FATTURE http://localhost:3001/fatture
    // Le fatture possono essere create solo dall'admin
    @PostMapping("")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Fattura saveFattura(@RequestBody @Validated FattureDTO body, BindingResult validation,
                               @AuthenticationPrincipal Utente utente) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }
        return fatturaService.save(body);

    }

    // GET DELLE FATTURE http://localhost:3001/fatture
    // Le fatture possono essere lette anche dagli utenti normali
    @GetMapping("")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public Page<Fattura> getFatture(@RequestParam(defaultValue = "0") int page,
                                    @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "idFatture") String sortBy) {
        return fatturaService.getFatture(page, size, sortBy);
    }

    // GET DELLE FATTURE CON FILTRI
    // Fatture filtrate per cliente
    @GetMapping("/cliente/{clienteId}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<Fattura> getByCliente(@PathVariable UUID clienteId) {
        return fatturaService.findByCliente(clienteId);
    }


    // Fatture filtrate per stato
    @GetMapping("/stato/{stato}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<Fattura> getByStato(@PathVariable EnumStatoFattura stato) {
        return fatturaService.findByStato(stato);
    }

    // Fatture filtrate per data yyyy-MM-dd
    @GetMapping("/data/{data}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<Fattura> getByData(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data
    ) {
        return fatturaService.findByData(data);
    }

    // Fatture filtrate per anno
    @GetMapping("/anno/{anno}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<Fattura> getByAnno(@PathVariable int anno) {
        return fatturaService.findByYear(anno);
    }

    // Fatture filtrate per range di importi
    @GetMapping("/importi")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public List<Fattura> getByImportoRange(
            @RequestParam double importoMin,
            @RequestParam double importoMax
    ) {
        return fatturaService.findByImportoBetween(importoMin, importoMax);
    }

    // MODIFICA FATTURE
    @PutMapping("/{idFatture}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Fattura updateFattura(
            @PathVariable UUID idFatture,
            @RequestBody @Validated FattureDTO body,
            BindingResult validation
    ) {
        if (validation.hasErrors()) {
            throw new BadRequestException(validation.getAllErrors());
        }

        return fatturaService.updateFattura(idFatture, body);
    }

}

