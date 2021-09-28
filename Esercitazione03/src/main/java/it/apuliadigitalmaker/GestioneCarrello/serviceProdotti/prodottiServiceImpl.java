package main.java.it.apuliadigitalmaker.GestioneCarrello.serviceProdotti;

import it.apuliadigilalmaker.GestioneCarrello.model.Prodotti;
import it.apuliadigilalmaker.GestioneCarrello.repository.prodottiRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class prodottiServiceImpl implements prodottiService {
    private final prodottiRepository prodottiRepsository;

    public prodottiServiceImpl(prodottiRepository prodottiRepsository) {
        this.prodottiRepsository = prodottiRepsository;
    }


    @Override
    public List<Prodotti> getProdotti() {
        return this.prodottiRepsository.findAll();
    }

    @Override
    public void insertProdotto(Prodotti prodotti) {
        this.prodottiRepsository.save(prodotti);
    }

    @Override
    public void updateProdotto(Prodotti prodotti) {
        if(this.findProdottoByNome(prodotti.getNomeProd()).equals(prodotti))
           prodottiRepsository.save(prodotti);
        else
            log.error("Prodotto da aggiornare {} non trovato nel db ", prodotti.getNomeProd());
    }

    @Override
    public void deleteProdotto(String id){
    prodottiRepsository.deleteById(id);
    }

    @Override
    public Prodotti findProdottoByNome(String nomeProd) {
        return prodottiRepsository.findProdottoByNome(nomeProd);
    }
}
