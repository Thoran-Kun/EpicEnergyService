package com.team6.EpicEnergyService.CSV;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReaderBuilder;
import com.team6.EpicEnergyService.services.ProvinciaService;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.List;


@Slf4j
@Component
public class CSVReader {
    private ProvinciaService provinciaService;

    public List<String[]> fileReader(String file) {
        try {
            FileReader filereader = new FileReader(file);

            CSVReaderBuilder csvReader = new CSVReaderBuilder(filereader)
                    .withCSVParser(new CSVParserBuilder().withSeparator(';').build());

            List<String[]> allData = csvReader.build().readAll().stream().toList();
            for (String[] row : allData) {
                for (String cell : row) {
                    allData.add(row);
                }
            }
            return allData;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
}
