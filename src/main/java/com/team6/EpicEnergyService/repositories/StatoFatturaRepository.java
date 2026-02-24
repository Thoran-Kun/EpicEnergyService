package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.EnumStatoFattura;
import com.team6.EpicEnergyService.entities.StatoFattura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface StatoFatturaRepository extends JpaRepository<StatoFattura, UUID> {
    Optional<StatoFattura> findByStato(EnumStatoFattura stato);
}
