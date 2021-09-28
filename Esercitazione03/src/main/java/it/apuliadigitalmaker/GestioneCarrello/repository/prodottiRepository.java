package main.java.it.apuliadigitalmaker.GestioneCarrello.repository;

import it.apuliadigilalmaker.GestioneCarrello.model.Prodotti;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface prodottiRepository extends MongoRepository<Prodotti, String> {
        @Query("{ 'nomeProd' :?0 }")
        Prodotti findProdottoByNome(String nomeProd);
}
