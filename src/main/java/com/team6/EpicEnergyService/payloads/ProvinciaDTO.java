package com.team6.EpicEnergyService.payloads;

import jakarta.validation.constraints.NotBlank;

public record ProvinciaDTO(
        @NotBlank String sigla,
        @NotBlank String provincia,
        @NotBlank String regione) {
}
