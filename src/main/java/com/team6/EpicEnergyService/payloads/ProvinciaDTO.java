package com.team6.EpicEnergyService.payloads;

import jakarta.validation.constraints.NotBlank;

public record ProvinciaDTO(
        @NotBlank String nome,
        @NotBlank String sigla) {
}
