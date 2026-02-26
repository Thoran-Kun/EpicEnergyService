package com.team6.EpicEnergyService.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Clienti")
public class Cliente {
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "indirizziCliente",
            joinColumns = @JoinColumn(name = "cliente_id"),
            inverseJoinColumns = @JoinColumn(name = "indirizzo_id")
    )
    private List<Indirizzo> listaIndirizzi = new ArrayList<>();
    @Id
    @GeneratedValue
    @Getter(AccessLevel.NONE)
    @Column(name = "id_cliente")
    private UUID id;
    @Enumerated(EnumType.STRING)
    private RagioneSociale ragioneSociale;
    private String partitaIva;
    private String email;
    private LocalDate dataInserimento;
    private LocalDate dataUltimoContatto;
    private double fatturatoAnnuale;
    private String pec;
    private String telefono;
    private String emailContatto;
    private String nomeContatto;
    private String cognomeContatto;
    private String telefonoContatto;
    private String logoAziendale;
    @OneToMany(mappedBy = "cliente")
    private List<Fattura> listaFatture = new ArrayList<>();


    public Cliente(String nomeContatto, String cognomeContatto, String emailContatto, String telefono, RagioneSociale ragioneSociale, String partitaIva) {
        this.nomeContatto = nomeContatto;
        this.cognomeContatto = cognomeContatto;
        this.emailContatto = emailContatto;
        this.email = emailContatto;
        this.dataInserimento = LocalDate.now();
        this.telefono = telefono;
        this.telefonoContatto = telefono;
        this.ragioneSociale = ragioneSociale;
        this.partitaIva = partitaIva;
        if (!listaFatture.isEmpty()) {
            this.dataUltimoContatto = listaFatture.get(listaFatture.size() - 1).getData();
            this.fatturatoAnnuale = listaFatture.stream().mapToDouble(Fattura::getImporto).sum();
        } else {
            this.dataUltimoContatto = null;
            this.fatturatoAnnuale = 0.0;
        }
        this.pec = emailContatto;
    }
}
