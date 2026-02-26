package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, UUID> {

    // Filtri clienti

    // Filtra la lista clienti per il fatturato annuale
    List<Cliente> findByFatturatoAnnuale(double fatturato);

    // Filtra la lista clienti per data di inserimento
    List<Cliente> findByDataInserimento(LocalDate dataInserimento);

    // Filtra la lista clienti per la data di ultimo contatto
    List<Cliente> findByDataUltimoContatto(LocalDate dataUltimoContatto);

    // Filtra la lista clienti per Parte del cognome
    List<Cliente> findByCognomeContattoContainingIgnoreCase(String cognomeParziale);

    // Ordinamento clienti

    // Ordina i clienti per nome
    List<Cliente> findAllByOrderByNomeContattoAsc();

    // Ordina i clienti per fatturato annuale
    List<Cliente> findAllByOrderByFatturatoAnnualeAsc();

    // Ordina i clienti per data di inserimento
    List<Cliente> findAllByOrderByDataInserimentoAsc();

    // Ordina i clienti per data di ultimo contatto
    List<Cliente> findAllByOrderByDataUltimoContattoAsc();

    // Ordina i clienti per provincia della sede legale


}
