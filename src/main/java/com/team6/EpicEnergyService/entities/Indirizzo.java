package com.team6.EpicEnergyService.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "indirizzi")
@Getter
@Setter
@NoArgsConstructor
public class Indirizzo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String via;
    private String civico;
    private String localita;
    private int cap;
    private TipoSede tipoSede;

    @ManyToOne
    @JoinColumn(name = "comune_id")
    private Comune comune;

    public Indirizzo(String via, String civico, String localita, Comune comune, int cap, TipoSede tipoSede) {
        this.via = via;
        this.civico = civico;
        this.localita = localita;
        this.comune = comune;
        this.cap = cap;
        this.tipoSede = tipoSede;
    }
}
