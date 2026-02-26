package com.team6.EpicEnergyService.runner;

import com.team6.EpicEnergyService.entities.EnumStatoFattura;
import com.team6.EpicEnergyService.entities.EnumTipoUtente;
import com.team6.EpicEnergyService.entities.StatoFattura;
import com.team6.EpicEnergyService.entities.TipoUtente;
import com.team6.EpicEnergyService.payloads.UtentiDTO;
import com.team6.EpicEnergyService.services.StatoFatturaService;
import com.team6.EpicEnergyService.services.TipoUtenteService;
import com.team6.EpicEnergyService.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class LoginRunner implements CommandLineRunner {
    @Autowired
    private UtenteService utenteService;
    @Autowired
    private TipoUtenteService tipoUtenteService;
    @Autowired
    private StatoFatturaService statoFatturaService;
    @Value("${PASS}")
    private String secret;

    public void run(String... args) throws Exception {

        // DA RUNNARE UNA VOLTA
//        TipoUtente admin = new TipoUtente(EnumTipoUtente.ADMIN);
//        tipoUtenteService.save(admin);
//        TipoUtente user = new TipoUtente(EnumTipoUtente.USER);
//        tipoUtenteService.save(user);

         //DA RUNNARE UNA VOLTA
//        UtentiDTO admino = new UtentiDTO("admino", "admino@email.com",
//                secret, "Adamo", "Mela", "ADMIN");
//        utenteService.saveUtente(admino);
//        UtentiDTO userino = new UtentiDTO("userino", "userino@email.com",
//        secret, "Eva", "Mela", "USER");
//        utenteService.saveUtente(userino);
//
//        StatoFattura pagata = new StatoFattura(EnumStatoFattura.PAGATA);
//        statoFatturaService.createStatoFattura(pagata.getStato());
//        StatoFattura annullata = new StatoFattura(EnumStatoFattura.ANNULLATA);
//        statoFatturaService.createStatoFattura(annullata.getStato());
//        StatoFattura inCarico = new StatoFattura(EnumStatoFattura.IN_CARICO);
//        statoFatturaService.createStatoFattura(inCarico.getStato());
    }

}
