package com.team6.EpicEnergyService.repositories;


import com.team6.EpicEnergyService.entities.EnumTipoUtente;
import com.team6.EpicEnergyService.entities.TipoUtente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TipoUtenteRepository extends JpaRepository<TipoUtente, UUID> {


    Optional<TipoUtente> findByTipo(EnumTipoUtente tipo);

}