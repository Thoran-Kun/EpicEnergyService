package com.team6.EpicEnergyService.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "utenti")
@NoArgsConstructor
@Getter
@Setter
public class Utente {

    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Getter(AccessLevel.NONE)
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    @Getter(AccessLevel.NONE)
    private String password;

    private String nome;
    private String cognome;
    private String avatar;

    @Enumerated(EnumType.STRING)
    private TipoUtente tipoUtente;

    public Utente(String username, String email, String password,
                  String nome, String cognome, TipoUtente tipoUtente) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.tipoUtente = tipoUtente;
    }
}

