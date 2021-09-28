package main.java.it.apuliadigitalmaker.GestioneCarrello.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Prodotti {

    @Id
    String id;
    @Indexed
    String nomeProd;
    float prezzo;
    String tipo;

}



