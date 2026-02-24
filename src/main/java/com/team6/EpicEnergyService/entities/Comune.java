package com.team6.EpicEnergyService.entities;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "comuni")
public class Comune {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    public Comune() {
    }

    public Comune(String nome, Provincia provincia) {
        this.nome = nome;
        this.provincia = provincia;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
}