package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.CSV.CSVReader;
import com.team6.EpicEnergyService.entities.Provincia;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.payloads.ProvinciaDTO;
import com.team6.EpicEnergyService.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProvinciaService {
    private ProvinciaRepository provinciaRepository;
    private CSVReader reader;

    @Autowired
    public ProvinciaService(ProvinciaRepository provinciaRepository, CSVReader reader) {
        this.provinciaRepository = provinciaRepository;
        this.reader = reader;
    }

    public Provincia save(ProvinciaDTO payload) {

//        reader.fileReader("provinceitaliane.csv");
        Provincia provincia = new Provincia(payload.sigla(), payload.provincia(), payload.regione());
        this.provinciaRepository.save(provincia);
        return provincia;
    }

    public Provincia findById(UUID uuid) {
        Optional<Provincia> optional = this.provinciaRepository.findById(uuid);
        if (optional.isPresent()) return optional.get();
        else throw new NotFoundException(uuid);
    }
}
