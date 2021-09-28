package main.java.it.apuliadigitalmaker.GestioneCarrello.controller;


import it.apuliadigilalmaker.GestioneCarrello.model.Prodotti;
import main.java.it.apuliadigitalmaker.GestioneCarrello.serviceProdotti.prodottiService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/prodottoManager")
public class prodottiController {
    private final prodottiService prodottiService;


    public prodottiController(main.java.it.apuliadigitalmaker.GestioneCarrello.serviceProdotti.prodottiService prodottiService) {
        this.prodottiService = prodottiService;
    }

    @GetMapping("/listaProd")
    ResponseEntity<List<Prodotti>> findAllProdotti() {
        return ResponseEntity.ok().body(prodottiService.getProdotti());
    }

    @PostMapping
    ResponseEntity<Prodotti> insertProdotti(@RequestBody Prodotti prodotti) {
        prodottiService.insertProdotto(prodotti);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/prodottoManager" + prodotti.getId()).toUriString());
        return ResponseEntity.created(uri).body(prodotti);
    }

    @PutMapping("/{nomeProd}")
    ResponseEntity<?> updateProdotto(@PathVariable String nomeProd, @RequestBody Prodotti prodotto) {
        prodottiService.updateProdotto(prodotto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{prod_id}")
    ResponseEntity<?> deleteProdotto(@PathVariable String prod_id) {
        prodottiService.deleteProdotto(prod_id);
        return ResponseEntity.ok().build();
    }
}
