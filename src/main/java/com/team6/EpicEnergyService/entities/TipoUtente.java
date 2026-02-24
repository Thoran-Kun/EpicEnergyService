package com.team6.EpicEnergyService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tipo_utenti")
public class TipoUtente {
    @Id
    @GeneratedValue
    private UUID id_tipo_utente;

    @Enumerated(EnumType.STRING)
    private EnumTipoUtente tipo;
    }