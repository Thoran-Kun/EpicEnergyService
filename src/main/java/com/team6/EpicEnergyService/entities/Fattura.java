package com.team6.EpicEnergyService.entities;


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

    // incremento automaticamente il numero della fattura
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;

    @ManyToOne
    @JoinColumn(name = "fatture_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "stato_fatture", nullable = false)
    @Enumerated(EnumType.STRING)
    private EnumStatoFattura statoFattura;

    public Fattura(double importo, Cliente cliente) {
        this.data = LocalDate.now();
        this.importo = importo;
        this.cliente = cliente;
        this.statoFattura = EnumStatoFattura.IN_CARICO;
        // assegno lo stato della fattura direttamente durante la creazione
    }
}
