package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.entities.Utente;
import com.team6.EpicEnergyService.payloads.LoginDTO;
import com.team6.EpicEnergyService.security.JWTTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UtenteService utenteService;
    private final JWTTools jwtTools;
    private final PasswordEncoder bcrypt;

    @Autowired
    public AuthService(UtenteService utenteService, JWTTools jwtTools, PasswordEncoder bcrypt) {
        this.utenteService = utenteService;
        this.jwtTools = jwtTools;
        this.bcrypt = bcrypt;
    }

    public String checkCredentialAndGenerateToken(LoginDTO body){
        Utente found = this.utenteService.findByEmail(body.email());
    }
}
