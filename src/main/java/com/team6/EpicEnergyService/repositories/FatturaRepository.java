package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.Fattura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FatturaRepository extends JpaRepository<Fattura, UUID> {
}
