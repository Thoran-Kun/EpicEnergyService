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
        String line;
        String delimiter = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                if (values.length >= 3) {
                    Provincia provincia = new Provincia();
                    provincia.setSigla(values[0]);
                    if (values[1].equals("Aosta")) {
                        values[1] = "Valle d'Aosta/Vallée d'Aoste";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else if (values[1].equals("Monza-Brianza")) {
                        values[1] = "Monza e della Brianza";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else if (values[1].equals("Bolzano")) {
                        values[1] = "Bolzano/Bozen";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else if (values[1].equals("La-Spezia")) {
                        values[1] = "La Spezia";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else if (values[1].equals("Reggio-Emilia")) {
                        values[1] = "Reggio nell'Emilia";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else if (values[1].equals("Forli-Cesena")) {
                        values[1] = "Forlì-Cesena";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else if (values[1].equals("Pesaro-Urbino")) {
                        values[1] = "Pesaro e Urbino";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else if (values[1].equals("Ascoli-Piceno")) {
                        values[1] = "Ascoli Piceno";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else if (values[1].equals("Reggio-Calabria")) {
                        values[1] = "Reggio Calabria";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else if (values[1].equals("Vibo-Valentia")) {
                        values[1] = "Vibo Valentia";
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    } else {
                        provincia.setProvincia(values[1]);
                        provincia.setRegione(values[2]);
                        provinciaService.save(provincia);
                    }
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

