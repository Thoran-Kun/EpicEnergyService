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
@Table(name = "province")
public class Provincia {
    @Id
    @GeneratedValue
    private UUID id_provincia;

    private String nome;

    private String sigla;

    @OneToMany
    @JoinColumn(name = "provincia_id", nullable = false)
    private Comune comune;

}
