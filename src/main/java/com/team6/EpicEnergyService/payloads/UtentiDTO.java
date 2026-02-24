package com.team6.EpicEnergyService.payloads;

import com.team6.EpicEnergyService.entities.TipoUtente;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record UtentiDTO(

        UUID id,

        @NotBlank(message = "Username obbligatorio")
        String username,

        @Email(message = "Email non valida")
        @NotBlank(message = "Email obbligatoria")
        String email,
        @NotBlank
        String password,
        String nome,
        String cognome,
        String avatar,
        TipoUtente tipoUtente
) {
}