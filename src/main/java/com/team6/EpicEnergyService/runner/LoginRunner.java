package com.team6.EpicEnergyService.runner;

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
    @Value("${PASS}")
    private String secret;

    public void run(String... args) throws Exception {

        // DA RUNNARE UNA VOLTA
        //TipoUtente admin = new TipoUtente(EnumTipoUtente.ADMIN);
        //tipoUtenteService.save(admin);
        //TipoUtente user = new TipoUtente(EnumTipoUtente.USER);
        //tipoUtenteService.save(user);

        // DA RUNNARE UNA VOLTA
        //UtentiDTO admino = new UtentiDTO("admino", "admino@email.com",
        // secret, "Adamo", "Mela", "ADMIN");
        // utenteService.saveUtente(admino);
    }

}
