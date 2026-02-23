package com.team6.EpicEnergyService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "utenti")
@NoArgsConstructor
@Builder
public class Utente {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String nome;
    private String cognome;
    private String avatar;

    @Enumerated(EnumType.STRING)
    private TipoUtente tipoUtente;
    public Utente(UUID id, String username, String email, String password,
                  String nome, String cognome, String avatar, TipoUtente tipoUtente) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.avatar = avatar;
        this.tipoUtente = tipoUtente;
    }
}

