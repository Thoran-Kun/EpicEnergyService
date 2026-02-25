package com.team6.EpicEnergyService.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "tipo_utenti")
public class TipoUtente {
    @Id
    @GeneratedValue
    private UUID id_tipo_utente;

    @Enumerated(EnumType.STRING)
    private EnumTipoUtente tipo;

    public TipoUtente(EnumTipoUtente tipo) {
        this.tipo = tipo;
    }
}