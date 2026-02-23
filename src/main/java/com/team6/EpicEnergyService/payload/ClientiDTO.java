package com.team6.EpicEnergyService.payload;

import com.team6.EpicEnergyService.entities.RagioneSociale;

public record ClientiDTO(String nomeContatto, String cognomeContatto, String emailContatto,
                         RagioneSociale ragioneSociale, String partitaIva) {
}
