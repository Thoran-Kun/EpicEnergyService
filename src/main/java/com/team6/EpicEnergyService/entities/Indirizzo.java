package com.team6.EpicEnergyService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name="indirizzi")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Indirizzo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;

    private String via;
    private String civico;
    private String localita;
    private int cap;

    @OneToOne
    @JoinColumn(name = "comune_id")
    private Comune comune;

}
