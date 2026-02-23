package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UtenteRepo extends JpaRepository<Utente, UUID> {
   Optional<Utente> findByEmail(String email);
}
