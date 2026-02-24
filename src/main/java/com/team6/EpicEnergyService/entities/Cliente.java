package com.team6.EpicEnergyService.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Clienti")
public class Cliente {
    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    private UUID id_cliente;
    @Enumerated(EnumType.STRING)
    private RagioneSociale ragioneSociale;
    private String partitaIva;
    private String email;
    private LocalDate dataInserimento;
    private LocalDate dataUltimoContatto;
    private double fatturatoAnnuale;
    private String pec;
    private int telefono;
    private String emailContatto;
    private String nomeContatto;
    private String cognomeContatto;
    private int telefonoContatto;
    private String logoAziendale;
    @OneToMany(mappedBy = "cliente")
    private List<Indirizzo> listaIndirizzi;
    @OneToMany(mappedBy = "cliente")
    private List<Fattura> listaFatture;

    public Cliente(String nomeContatto, String cognomeContatto, String emailContatto, RagioneSociale ragioneSociale, String partitaIva) {
        this.nomeContatto = nomeContatto;
        this.cognomeContatto = cognomeContatto;
        this.emailContatto = emailContatto;
        this.ragioneSociale = ragioneSociale;
        this.partitaIva = partitaIva;
    }
}
