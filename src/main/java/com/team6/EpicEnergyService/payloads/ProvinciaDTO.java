package com.team6.EpicEnergyService.payloads;

import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record ProvinciaDTO(
        @NotBlank String nome,
        @NotBlank String sigla,
        @NotBlank UUID id_comune) {
}
