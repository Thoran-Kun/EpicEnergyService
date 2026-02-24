package com.team6.EpicEnergyService.CSV;


import com.team6.EpicEnergyService.entities.Comune;
import com.team6.EpicEnergyService.entities.Provincia;
import com.team6.EpicEnergyService.services.ComuneService;
import com.team6.EpicEnergyService.services.ProvinciaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


@Slf4j
@Component
public class CSVReader {

    @Autowired
    private ProvinciaService provinciaService;
    @Autowired
    private ComuneService comuneService;

    public void readAllProvince(String filePath) {
//        String filePath = "provinceitaliane.csv";
        String line;
        String delimiter = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length >= 3) {
                    Provincia provincia = new Provincia();
                    provincia.setSigla(values[0]);
                    provincia.setProvincia(values[1]);
                    provincia.setRegione(values[2]);
                    provinciaService.save(provincia);
                }
            }
            provinciaService.save(new Provincia("VB", "Verbano-Cusio-Ossola", "Piemonte"));
            provinciaService.save(new Provincia("SC", "Sud Sardegna", "Sardegna"));
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void readAllComuni(String filePath) {
        String line;
        String delimiter = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length >= 3) {
                    Comune comune = new Comune();
                    comune.setNome(values[2]);
                    if (values[3].equals("Valle d'Aosta/Vallée d'Aoste")) {
                        values[3] = "Aosta";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    if (values[3].equals("Monza e della Brianza")) {
                        values[3] = "Monza-Brianza";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    if (values[3].equals("Bolzano/Bozen")) {
                        values[3] = "Bolzano";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    if (values[3].equals("La Spezia")) {
                        values[3] = "La-Spezia";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    if (values[3].equals("Reggio nell'Emilia")) {
                        values[3] = "Reggio-Emilia";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    if (values[3].equals("Forlì-Cesena")) {
                        values[3] = "Forli-Cesena";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    if (values[3].equals("Pesaro e Urbino")) {
                        values[3] = "Pesaro-Urbino";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    if (values[3].equals("Ascoli Piceno")) {
                        values[3] = "Ascoli-Piceno";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    if (values[3].equals("Reggio Calabria")) {
                        values[3] = "Reggio-Calabria";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    if (values[3].equals("Vibo Valentia")) {
                        values[3] = "Vibo-Valentia";
                        comune.setProvincia(provinciaService.findByProvincia(values[3]));
                        comuneService.save(comune);
                    }
                    Provincia provincia = provinciaService.findByProvincia(values[3]);
                    comune.setProvincia(provincia);
                    comuneService.save(comune);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }


}

