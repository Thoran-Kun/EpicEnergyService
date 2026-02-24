package com.team6.EpicEnergyService.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    private String sigla;
    private String provincia;
    private String regione;

//    @OneToMany
//    @JoinColumn(name = "provincia_id", nullable = false)
//    private List<Comune> listaComuni;

    public Provincia(String sigla, String provincia, String regione) {
        this.sigla = sigla;
        this.provincia = provincia;
        this.regione = regione;
    }
}
