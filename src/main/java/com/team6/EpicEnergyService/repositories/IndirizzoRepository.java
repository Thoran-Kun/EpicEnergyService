package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.Indirizzo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IndirizzoRepository extends JpaRepository <Indirizzo, UUID> {
}
