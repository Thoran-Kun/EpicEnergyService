package com.team6.EpicEnergyService.payloads;

import com.team6.EpicEnergyService.entities.RagioneSociale;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClientiDTO(String nomeContatto,
                         String cognomeContatto,
                         String emailContatto,
                         RagioneSociale ragioneSociale,
                         String partitaIva,
                         @NotBlank(message = "la via è obbligatoria")
                         String via,
                         @NotBlank(message = "il numero civico è obbligatorio")
                         String civico,
                         @NotBlank(message = "la località è obbligatoria")
                         String localita,
                         @NotNull(message = "il CAP è obbligatorio")
                         int cap,
                         @NotNull
                         String citta,
                         @NotNull(message = "numero di telefono obbligatorio")
                         //@Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$")
                         int numeroDiTelefono,
                         @NotBlank(message = "la pec è obbligatoria")
                         String pec
) {
}
