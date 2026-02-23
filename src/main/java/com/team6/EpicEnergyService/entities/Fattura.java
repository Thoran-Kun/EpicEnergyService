package com.team6.EpicEnergyService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "fatture")
public class Fattura {
    @Id
    @GeneratedValue
    private UUID id_fatture;

    private LocalDate data;

    private BigInteger importo;

    private BigInteger numero;

    @ManyToOne
    @JoinColumn(name = "fatture_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "stato_fatture", nullable = false)
    private StatoFattura stato;

}
