package com.team6.EpicEnergyService.tools;

import com.team6.EpicEnergyService.entities.Cliente;
import com.team6.EpicEnergyService.entities.Fattura;
import kong.unirest.core.HttpResponse;
import kong.unirest.core.JsonNode;
import kong.unirest.core.Unirest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

    private String domain;
    private String apiKey;
    private String emailFrom;

    public EmailSender(@Value("${mailgun.domain}") String domain,
                       @Value("${mailgun.apiKey}") String apiKey,
                       @Value("${email.from}") String emailFrom) {
        this.domain = domain;
        this.apiKey = apiKey;
        this.emailFrom = emailFrom;
    }

    public void sendRegistration(Cliente recipient) {
        HttpResponse<JsonNode> response = Unirest.post("https://api.mailgun.net/v3/" + this.domain + "/messages").basicAuth("api", apiKey)
                .queryString("from", emailFrom)
                .queryString("to", recipient.getEmailContatto())
                .queryString("subject", "Benvenuto in EpicEnergyService")
                .queryString("text", "Ciao " + recipient.getNomeContatto() + ",la tua registrazione è andata a buon fine :)")
                .asJson();

        if (response.getStatus() == 200) {
            System.out.println("Email inviata con successo");// log per ispezionare la risposta e poter debuggare più facilmente
        } else {
            System.out.println("Errore in Mailgun: " + response.getBody());
        }
    }

//    public void sendBilingEmail(Cliente recipient) {
//    }

    public void inviaFattura(Cliente cliente, Fattura fattura) {
        HttpResponse<JsonNode> response = Unirest.post("https://api.mailgun.net/v3/" + this.domain + "/messages").basicAuth("api", apiKey)
                .queryString("from", emailFrom)
                .queryString("to", cliente.getEmailContatto())
                .queryString("subject", "Ecco i dati della tua ultima fattura:")
                .queryString("text", "Fattura emessa in data:" + fattura.getData() + " con importo: " + fattura.getImporto() + " €.")
                .asJson();
        if (response.getStatus() == 200) {
            System.out.println("Email inviata con successo");
        } else {
            System.out.println("Errore in Mailgun: " + response.getBody());
        }
    }
}
