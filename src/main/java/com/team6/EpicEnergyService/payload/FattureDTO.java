package com.team6.EpicEnergyService.payload;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record FattureDTO(
        @NotNull(message = "L'importo è obbligatorio!")
        @Min(value = 1, message = "Attenzione! L'importo minimo è 1.")
        @Max(value = 100000, message = "Attenzione! L'importo massimo è 100000.")
        double importo,
        @NotNull(message = "Attenzione! L'ID del cliente è obbligatorio.")
        UUID clienteId

) {
}

