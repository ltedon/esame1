package main.java.it.apuliadigitalmaker.GestioneCarrello.repository;

import it.apuliadigilalmaker.GestioneCarrello.model.Carrello;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface carrelloRepository extends MongoRepository<Carrello, String> {

    @Query ("{'carr_id': ?0}")
        Carrello findCarrelloById(String carr_id );
}
