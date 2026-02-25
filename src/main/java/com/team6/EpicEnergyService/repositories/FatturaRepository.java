package com.team6.EpicEnergyService.repositories;

import com.team6.EpicEnergyService.entities.Fattura;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

// Filtrare le fatture per: cliente, stato, data, anno, range di importi
public interface FatturaRepository extends JpaRepository<Fattura, UUID> {
//
//    // Filtro le fatture per cliente
//    List<Fattura> findByCliente_Id_cliente(UUID idCliente);
//
//    // Filtro le fatture per stato
//    List<Fattura> findByStatoFattura_Stato(EnumStatoFattura stato);
//
//    // Filtro le fatture per data
//    List<Fattura> findByData(LocalDate data);
//
//    // Filtro le fatture per anno con JPQL
//    @Query("SELECT f FROM Fattura f WHERE YEAR(f.data) = :anno")
//    List<Fattura> findByYear(@Param("anno") int anno);
//
//    // Filtro le fatture per range di importi
//    List<Fattura> findByImportoBetween(double importoMin, double importoMax);

}
