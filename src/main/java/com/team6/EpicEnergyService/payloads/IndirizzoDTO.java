package com.team6.EpicEnergyService.payloads;

import com.team6.EpicEnergyService.entities.TipoSede;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record IndirizzoDTO(
        @NotBlank(message = "la via è obbligatoria")
        String via,
        @NotBlank(message = "il numero civico è obbligatorio")
        String civico,
        @NotBlank(message = "la località è obbligatoria")
        String localita,
        @NotNull(message = "il CAP è obbligatorio")
        int cap,
        @NotBlank
        String citta,
        @NotNull
        TipoSede tipoSede
) {
}
