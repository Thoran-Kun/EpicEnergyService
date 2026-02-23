package com.team6.EpicEnergyService.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record IndirizzoDTO(
        @NotBlank(message = "la via è obbligatoria")
        String via,
        @NotBlank(message = "il numero civico è obbligatorio")
        String civico,
        @NotBlank(message = "la località è obbligatoria")
        String localita,
        @NotNull(message = "il CAP è obbligatorio")
        int cap,
        @NotNull(message = "l'ID del comune è obbligatorio")
        UUID comuneId
) {
}
