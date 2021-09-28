package main.java.it.apuliadigitalmaker.GestioneCarrello.config;

import it.apuliadigilalmaker.GestioneCarrello.model.Carrello;
import it.apuliadigilalmaker.GestioneCarrello.model.NotaSpesa;
import it.apuliadigilalmaker.GestioneCarrello.model.Prodotti;
import main.java.it.apuliadigitalmaker.GestioneCarrello.repository.carrelloRepository;
import main.java.it.apuliadigitalmaker.GestioneCarrello.repository.prodottiRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class prodottoConfig {
    @Bean
    CommandLineRunner commandLineRunner(prodottiRepository repository, carrelloRepository carrello) {
        return args -> {
            Prodotti prod1 = new Prodotti("1", "libro", 15.50F,"cancelleria");
            Prodotti prod2 = new Prodotti("2", "quaderno", 25F,"cancelleria");

        List<NotaSpesa> lista1 = new ArrayList<>();
        lista1.add(new NotaSpesa(prod1, 3));
        lista1.add(new NotaSpesa(prod2, 5));

        List<NotaSpesa> lista2 = new ArrayList();
        lista2.add(new NotaSpesa(prod1, 1));
        lista2.add(new NotaSpesa(prod2, 2));

        Date data1 = new Date();
        Date data2 = new Date();

        Carrello carrello1 = new Carrello("carr1",lista1, data1, 171.5F);
        Carrello carrello2 = new Carrello("carr2",lista2, data2, 65.50F);

        List<Carrello> temp1 =  new ArrayList<>();
        temp1.add(carrello1);
        temp1.add(carrello2);
            carrello.deleteAll();
            carrello.saveAll(temp1);

        List<Prodotti> temp =  new ArrayList<>();
        temp.add(prod1);
        temp.add(prod2);
        repository.deleteAll();
        repository.saveAll(
                temp
            );
        };
    }
}
