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

    public Provincia(String nome, String sigla, Comune comune) {
        this.nome = nome;
        this.sigla = sigla;
        this.comune = comune;
    }
}
