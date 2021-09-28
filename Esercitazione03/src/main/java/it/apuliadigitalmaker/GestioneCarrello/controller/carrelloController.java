package main.java.it.apuliadigitalmaker.GestioneCarrello.controller;

import it.apuliadigilalmaker.GestioneCarrello.model.Carrello;
import it.apuliadigilalmaker.GestioneCarrello.model.NotaSpesa;
import main.java.it.apuliadigitalmaker.GestioneCarrello.serviceCarrello.serviziCarrello;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "/carrelloManager")
public class carrelloController {
   public final serviziCarrello serviziCar;

    public carrelloController(serviziCarrello serviziCar) {
        this.serviziCar = serviziCar;
    }


    @GetMapping("/lista_carrelli")
    ResponseEntity<List<Carrello>> findALLcar() {
        return ResponseEntity.ok().body(serviziCar.getAllCarrrelli());
    }

    @PostMapping
    ResponseEntity<Carrello> insertCarrello(@RequestBody List<NotaSpesa> listaSpesa) {
        Carrello car = serviziCar.creaCarrello(listaSpesa);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/carrelloManager/" + car.getCarr_id()).toUriString());

        log.info("Il carrello {} creato raggiungibile al link {} ", car.getCarr_id(), uri.toString());
        return ResponseEntity.created(uri).body(car);
        }

}
