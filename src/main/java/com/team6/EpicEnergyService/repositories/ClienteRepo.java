package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, UUID> {
}
