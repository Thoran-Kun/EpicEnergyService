package com.team6.EpicEnergyService.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ComuneDTO(

        @NotEmpty(message = "Il nome è obbligatorio")
        String nome,

        @NotNull(message = "La provincia è obbligatoria")
        UUID provinciaId) {
}