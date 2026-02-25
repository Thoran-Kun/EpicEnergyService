package com.team6.EpicEnergyService.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@NoArgsConstructor
@Table(name = "fatture")
public class Fattura {
    @Id
    @GeneratedValue
    private UUID id_fatture;

    private LocalDate data;

    private double importo;

    // per comodità il numero della fattura sarà sequenziale
    @Column(nullable = false)
    private int numero;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "stato_fattura_id", nullable = false)
    private StatoFattura statoFattura;

    public Fattura(double importo, Cliente cliente, StatoFattura statoFattura) {
        this.data = LocalDate.now();
        this.importo = importo;
        this.cliente = cliente;
        this.statoFattura = statoFattura;
    }
}
