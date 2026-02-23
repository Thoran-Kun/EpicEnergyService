package com.team6.EpicEnergyService.controllers;

import com.team6.EpicEnergyService.entities.Indirizzo;
import com.team6.EpicEnergyService.exceptions.ValidationException;
import com.team6.EpicEnergyService.payloads.IndirizzoDTO;
import com.team6.EpicEnergyService.services.IndirizzoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/indirizzo")
public class IndirizzoController {
    private final IndirizzoService indirizzoService;

    @Autowired
    public IndirizzoController(IndirizzoService indirizzoService) {
        this.indirizzoService = indirizzoService;
    }

    @PostMapping
    @PreAuthorize("hasAnyAuthority('USER', 'AMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public Indirizzo saveIndirizzo(@RequestBody @Validated IndirizzoDTO payload,
                                   BindingResult validationResult){
        if(validationResult.hasErrors()){
            List<String> errorsList = validationResult.getFieldErrors().stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();
            throw new ValidationException(errorsList);
        } else {
            return this.indirizzoService.saveIndirizzo(payload);
        }

    }

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Page<Indirizzo> findAll(Pageable pageable){
        return indirizzoService.findAll(pageable);
    }

}
