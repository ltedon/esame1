package it.apulia.es02.Esercitazione02.JPA;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

        //select * from books where titolo=:titolo
        @Query("SELECT b FROM Book b WHERE b.titolo = ?1")
        List<Book> findBookByTitle(String titolo);

}
