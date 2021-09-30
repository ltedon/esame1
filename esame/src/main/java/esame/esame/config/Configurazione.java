package esame.esame.config;


import esame.esame.model.*;
import esame.esame.repo.CarrelloRepo;
import esame.esame.repo.ProductsRepo;
import esame.esame.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Configuration
public class Configurazione {
    @Bean
    CommandLineRunner commandLineRunner(UserService userService, ProductsRepo repository, CarrelloRepo repoCarrello) {
        return args -> {
            userService.resetAll();


            userService.saveRole(new Role("ROLE_USER"));
            userService.saveRole(new Role("ROLE_ADMIN"));

            userService.saveUtente(new Utente("abc", "john", "1234", new ArrayList<>()));
            userService.saveUtente(new Utente("bcd", "will", "1234", new ArrayList<>()));
            userService.saveUtente(new Utente("cde", "jim", "1234", new ArrayList<>()));
            userService.saveUtente(new Utente("def", "arnold", "1234", new ArrayList<>()));

            userService.addRoleToUtente("john", "ROLE_USER");
            userService.addRoleToUtente("jim", "ROLE_ADMIN");
            userService.addRoleToUtente("arnold", "ROLE_ADMIN");
            userService.addRoleToUtente("arnold", "ROLE_USER");

            Prodotto prodotto1 = new Prodotto(10001,"Latte",1.20, "http://localhost:8080/market/prodotti/10001");
            Prodotto prodotto2 = new Prodotto(10002,"Uova",2.00, "http://localhost:8080/market/prodotti/10002");
            Prodotto prodotto3 = new Prodotto(10003,"Biscotti",3.60, "http://localhost:8080/market/prodotti/10003");
            Prodotto prodotto4 = new Prodotto(10004,"Lattuga",1.00, "http://localhost:8080/market/prodotti/10004");
            Prodotto prodotto5 = new Prodotto(10005,"Manzo",4.50, "http://localhost:8080/market/prodotti/10005");

            List<Prodotto> temp= new ArrayList<>();
            temp.add(prodotto1);
            temp.add(prodotto2);
            temp.add(prodotto3);
            temp.add(prodotto4);
            temp.add(prodotto5);

            List<VoceScontrino> temps = new ArrayList<>();
            temps.add(new VoceScontrino("Uova",2,4.00));
            temps.add(new VoceScontrino("Latte",1,1.20));
            List<VoceScontrino> temps2 = new ArrayList<>();
            temps2.add(new VoceScontrino("Biscotti",2,7.20));
            temps2.add(new VoceScontrino("Latte",1,1.20));
            //Date datafittizia = new Date();
            //datafittizia.setYear(datafittizia.getYear()-1);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
            LocalDateTime datafittizia = LocalDateTime.now().minusYears(1);

            System.out.println(dtf.format(datafittizia));
            Carrello carrello1 = new Carrello(10001,temps,dtf.format(datafittizia),5.20,"http://localhost:8080/market/carrelli/10001");
            Carrello carrello2 = new Carrello(10002,temps2,dtf.format(datafittizia),8.40,"http://localhost:8080/market/carrelli/10002");

            List<Carrello> tempcr = new ArrayList<>();
            tempcr.add(carrello1);
            tempcr.add(carrello2);

            repository.deleteAll();
            repoCarrello.deleteAll();

            repository.saveAll(
                    temp
            );

            repoCarrello.saveAll(tempcr);
        };

    }
}
