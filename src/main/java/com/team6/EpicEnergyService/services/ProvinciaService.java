package com.team6.EpicEnergyService.services;

import com.team6.EpicEnergyService.CSV.CSVReader;
import com.team6.EpicEnergyService.entities.Provincia;
import com.team6.EpicEnergyService.exceptions.NotFoundException;
import com.team6.EpicEnergyService.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProvinciaService {
    private ProvinciaRepository provinciaRepository;


    @Autowired
    public ProvinciaService(ProvinciaRepository provinciaRepository) {
        this.provinciaRepository = provinciaRepository;

    }

    public Provincia save(Provincia provincia) {

//        reader.fileReader("provinceitaliane.csv");
        Provincia provincia1 = new Provincia(provincia.getSigla(), provincia.getProvincia(), provincia.getRegione());
        this.provinciaRepository.save(provincia1);
        return provincia1;
    }

    public Provincia findById(UUID uuid) {
        Optional<Provincia> optional = this.provinciaRepository.findById(uuid);
        if (optional.isPresent()) return optional.get();
        else throw new NotFoundException(uuid);
    }
}
