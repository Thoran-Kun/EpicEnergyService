package com.team6.EpicEnergyService.CSV;


import com.opencsv.CSVReaderBuilder;
import com.team6.EpicEnergyService.entities.Provincia;
import com.team6.EpicEnergyService.repositories.ProvinciaRepository;
import com.team6.EpicEnergyService.services.ProvinciaService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


@Slf4j
@Component
public class CSVReader {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    public void readAllDataAtOnce(String filePath) {
//        String filePath = "provinceitaliane.csv";
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if(values.length >= 3){
                    Provincia provincia = new Provincia();
                    provincia.setSigla(values[0]);
                    provincia.setProvincia(values[1]);
                    provincia.setRegione(values[2]);
                    provinciaRepository.save(provincia);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

