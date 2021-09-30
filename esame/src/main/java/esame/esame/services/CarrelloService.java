package esame.esame.services;

import esame.esame.model.Carrello;
import esame.esame.model.NotaSpesa;
import esame.esame.model.RicercaCarrello;

import java.util.List;

public interface CarrelloService {

    public Carrello addCarrello(NotaSpesa notaSpesa);
    public Carrello getCarrellobyId(Integer id);
    public List<Carrello> getAllCarrelli();
    public RicercaCarrello findCarrelliByAnno(Integer anno);
    public RicercaCarrello findCarrelliByDataAndTotaleRange(Integer anno, Double min, Double max);
}
