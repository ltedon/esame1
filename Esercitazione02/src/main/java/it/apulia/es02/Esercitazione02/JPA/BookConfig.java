package it.apulia.es02.Esercitazione02.JPA;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner commandLineRunner(BookRepository repository) {
        return args -> {

            Book libro1 = new Book("Libro1", "Gennaro", 2005, "Link eBay");
            Book libro2 = new Book("Libro2", "Tatiana", 2021, "Link Amazon");

            repository.deleteAll();

            repository.saveAll(
                    List.of(libro1,libro2)
            );
        };

    }
}
