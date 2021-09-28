package main.java.it.apuliadigitalmaker.GestioneCarrello.serviceCarrello;

import it.apuliadigilalmaker.GestioneCarrello.model.Carrello;
import it.apuliadigilalmaker.GestioneCarrello.model.NotaSpesa;

import java.util.List;

public interface serviziCarrello {
    List<Carrello> getAllCarrrelli();
    Carrello creaCarrello(List<NotaSpesa> listaSpesa);

    Carrello findCarrelloById(String carr_id);
}
