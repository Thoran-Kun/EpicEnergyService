package com.team6.EpicEnergyService.controllers;

import com.team6.EpicEnergyService.entities.Utente;
import com.team6.EpicEnergyService.exceptions.ValidationException;
import com.team6.EpicEnergyService.payloads.LoginDTO;
import com.team6.EpicEnergyService.payloads.LoginResponseDTO;
import com.team6.EpicEnergyService.services.AuthService;
import com.team6.EpicEnergyService.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;
    private final UtenteService utenteService;

    @Autowired
    public AuthController(AuthService authService, UtenteService utenteService) {
        this.authService = authService;
        this.utenteService = utenteService;
    }

    @PostMapping("/login")
    public LoginResponseDTO loin(@RequestBody LoginDTO body){
        return new LoginResponseDTO(this.authService.checkCredentialAndGenerateToken(body));
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public Utente createUtente(@RequestBody @Validated UtenteDTO payload, BindingResult validationResult){
        if(validationResult.hasErrors()){
            List<String> errorList = validationResult.getFieldErrors()
                    .stream()
                    .map(fieldError -> fieldError.getDefaultMessage())
                    .toList();

            throw new ValidationException(errorList);
        } else {
            return this.utenteService.saveUtente(payload);
        }
    }
}
