package com.team6.EpicEnergyService.CSV;


import com.opencsv.CSVReaderBuilder;
import com.team6.EpicEnergyService.services.ProvinciaService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;


@Slf4j
@Component
public class CSVReader {


    public static void readAllDataAtOnce(String file) {
        String filePath = "provinceitaliane.csv";
        String line;
        String delimiter = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                for (String value : values) {
                    System.out.println(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

