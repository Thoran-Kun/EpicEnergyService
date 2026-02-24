package com.team6.EpicEnergyService.runner;

import com.team6.EpicEnergyService.CSV.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CSVRunner implements CommandLineRunner {

    @Autowired
    private CSVReader csvReader;

    @Override
    public void run(String... args) throws Exception {
        csvReader.readAllDataAtOnce("provinceitaliane.csv");
    }
}
