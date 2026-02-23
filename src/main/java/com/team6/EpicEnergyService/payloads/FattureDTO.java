package com.team6.EpicEnergyService.payloads;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record FattureDTO(
        @Min(value = 1, message = "Attenzione! L'importo minimo deve essere almeno 1.")
        @Max(value = 100000, message = "Attenzione! L'importo massimo consentito è 100000.")
        double importo,
        @NotNull(message = "Attenzione! l'ID del cliente è obbligatorio.")
        UUID comuneId
) {
}

