package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.EnumStatoFattura;
import com.team6.EpicEnergyService.entities.Fattura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

// Filtrare le fatture per: cliente, stato, data, anno, range di importi
public interface FatturaRepository extends JpaRepository<Fattura, UUID> {

    // Filtro le fatture per cliente
    //@Query("SELECT f FROM fatture f WHERE f.id_cliente = :id")
    //List<Fattura> findByIdCliente(@Param("id") UUID id);
    //List<Fattura> findByIdCliente(Cliente cliente);

    // Filtro le fatture per stato
    List<Fattura> findByStatoFattura_Stato(EnumStatoFattura stato);

    // Filtro le fatture per data
    List<Fattura> findByData(LocalDate data);

    // Filtro le fatture per anno con JPQL
    //@Query("SELECT f FROM fatture f WHERE YEAR(f.data) = :anno")
    //List<Fattura> findByYear(@Param("anno") int anno);

    // Filtro le fatture per range di importi
    List<Fattura> findByImportoBetween(double importoMin, double importoMax);

}
