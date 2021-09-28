package main.java.it.apuliadigitalmaker.GestioneCarrello.serviceProdotti;

import it.apuliadigilalmaker.GestioneCarrello.model.Prodotti;

import java.util.List;

public interface prodottiService {

    List<Prodotti> getProdotti();

    void insertProdotto(Prodotti prodotti);

    void updateProdotto(Prodotti prodotti);

    void deleteProdotto(String id);

    Prodotti findProdottoByNome(String nomeProd);
}
