package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    List<Cliente> findByFatturatoAnnuale(double fatturato);

    List<Cliente> findByDataInserimento(LocalDate dataInserimento);

    List<Cliente> findByDataUltimoContatto(LocalDate dataUltimoContatto);

    Optional<Cliente> findByPartitaIva(String partitaIva);

    //TODO: questa query è da sistemare
    //List<Cliente> findByName(String nomeParziale);

}
