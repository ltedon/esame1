package main.java.it.apuliadigitalmaker.GestioneCarrello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Carrello {


    @Id
    String carr_id;
    List<NotaSpesa> carrello;
    Date data;
    float prezzoTot;




    public Carrello( List<NotaSpesa> carrello, Date data,float prezzoTot) {
        this.carrello = carrello;
        this.prezzoTot = prezzoTot;
        this.data = data;
    }
}
