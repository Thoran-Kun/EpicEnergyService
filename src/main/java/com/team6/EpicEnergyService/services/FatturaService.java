package com.team6.EpicEnergyService.services;

import org.springframework.stereotype.Service;

@Service
public class FatturaService {
//
//    private final StatoFatturaService statoFatturaService;
//    private FatturaRepository fatturaRepository;
//    private ClienteService clienteService;
//
//
//    @Autowired
//    public FatturaService(FatturaRepository fatturaRepository, ClienteService clienteService,
//                          StatoFatturaService statoFatturaService
//    ) {
//        this.fatturaRepository = fatturaRepository;
//        this.clienteService = clienteService;
//        this.statoFatturaService = statoFatturaService;
//    }
//
//    // cerco la fattura per id
//    public Fattura findById(UUID id) {
//        return fatturaRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException(id.toString()));
//    }
//
//    // salvo la fattura
//    public Fattura save(FattureDTO payload) {
//
//        // recupero l'id del cliente
//        Cliente cliente = clienteService.findById(payload.clienteId());
//
//        // recupero lo stato (enum) della fattura tramite il suo id
//        StatoFattura stato = statoFatturaService.findByStato(payload.stato());
//
//        // creo la nuova fattura
//        Fattura nuovaFattura = new Fattura(payload.importo(), cliente, stato);
//
//        // incremento il numero di fattura
//        int nextNumero = (int) fatturaRepository.count() + 1;
//        nuovaFattura.setNumero(nextNumero);
//
//
//        return fatturaRepository.save(nuovaFattura);
//
//    }
//
//    // modifico la fattura (solo stato)
//    public Fattura updateStato(UUID fatturaId, EnumStatoFattura nuovoStato) {
//        // prendo la fattura tramite id
//        Fattura fattura = this.findById(fatturaId);
//
//        // prendo lo stato della fattura
//        StatoFattura stato = statoFatturaService.findByStato(nuovoStato);
//
//        // modifico lo stato
//        fattura.setStatoFattura(stato);
//
//        // la salvo
//        return fatturaRepository.save(fattura);
//    }
//
//
//    // modifico la fattura (campi importo e stato)
//    public Fattura updateFattura(UUID fatturaId, FattureDTO body, EnumStatoFattura nuovoStato) {
//        // prendo la fattura
//        Fattura fattura = this.findById(fatturaId);
//        // prendo lo stato della fattura
//        StatoFattura stato = statoFatturaService.findByStato(nuovoStato);
//        // modifico lo stato
//        fattura.setStatoFattura(stato);
//        // modifico l'importo
//        fattura.setImporto(body.importo());
//        // la salvo
//        return fatturaRepository.save(fattura);
//    }
//
//    // elimino la fattura per id
//    public void findByIdAndDelete(UUID fatturaId) {
//        Fattura fatturaDaEliminare = this.findById(fatturaId);
//        fatturaRepository.delete(fatturaDaEliminare);
//    }
//
//    // paginazione
//    public Page<Fattura> getFatture(int page, int size, String sortBy) {
//        if (size > 100) size = 100;
//        if (size < 1) size = 1;
//        if (page < 0) page = 0;
//        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        return fatturaRepository.findAll(pageable);
//    }
//
//    // prendo le fatture per cliente
//    public List<Fattura> findByCliente(UUID idCliente) {
//        return fatturaRepository.findByCliente_Id_cliente(idCliente);
//    }
//
//    // prendo le fatture per stato
//    public List<Fattura> findByStato(EnumStatoFattura stato) {
//        return fatturaRepository.findByStatoFattura_Stato(stato);
//    }
//
//    // prendo le fatture per data
//    public List<Fattura> findByData(LocalDate data) {
//        return fatturaRepository.findByData(data);
//    }
//
//    // prendo le fatture per anno
//    public List<Fattura> findByYear(int anno) {
//        return fatturaRepository.findByYear(anno);
//    }
//
//    // prendo le fatture per range di importi
//    public List<Fattura> findByImportoBetween(double importoMin, double importoMax) {
//        return fatturaRepository.findByImportoBetween(importoMin, importoMax);
//    }

}