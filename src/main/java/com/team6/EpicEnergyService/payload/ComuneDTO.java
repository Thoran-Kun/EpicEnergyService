package com.team6.EpicEnergyService.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public class ComuneDTO {

    @NotEmpty(message = "Il nome è obbligatorio")
    private String nome;

    @NotNull(message = "La provincia è obbligatoria")
    private UUID provinciaId;

    public ComuneDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public UUID getProvinciaId() {
        return provinciaId;
    }

    public void setProvinciaId(UUID provinciaId) {
        this.provinciaId = provinciaId;
    }
}