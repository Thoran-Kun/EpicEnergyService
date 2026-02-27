package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.Comune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ComuneRepository extends JpaRepository<Comune, UUID> {

    Optional<Comune> findByNome(String comune);
}