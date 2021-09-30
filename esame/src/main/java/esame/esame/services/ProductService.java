package esame.esame.services;

import esame.esame.model.Prodotto;

import java.util.List;

public interface ProductService {

    public Prodotto addProdotto(Prodotto prodotto);

    public Prodotto getProdottoById(Integer id);

    //serve per verificare che un prodotto con lo stesso nome non sia presente durante il salvataggio
    public Prodotto getProdottoByName(String nome);

    public List<Prodotto> getProdotti();

    public List<Prodotto> getProdottiNomeSimile(String nome);

    //  public List<Prodotto> getProdottiPrezzoSuperiore(Double prezzo);

    public void updateProdotto(Prodotto prodotto);

    public void deleteProdottoById(Integer id);

    public List<Prodotto> getProdottoInRange(Double minimo, Double massimo);


}
