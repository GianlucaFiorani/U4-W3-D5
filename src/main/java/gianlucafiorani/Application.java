package gianlucafiorani;

import com.github.javafaker.Faker;
import gianlucafiorani.dao.CatalogDAO;
import gianlucafiorani.dao.RentDAO;
import gianlucafiorani.dao.UserDAO;
import gianlucafiorani.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogDAO ca = new CatalogDAO(em);
        UserDAO us = new UserDAO(em);
        RentDAO rt = new RentDAO(em);
        Faker faker = new Faker();

        Book book1 = new Book("3456890", faker.book().title(), 2001, 250, faker.book().author(), Genre.GIALLO);
        Magazine m1 = new Magazine("123123", faker.book().title(), 2021, 15, Periodicity.MENSILE);

        User user1 = new User(faker.name().firstName(), faker.name().lastName(), LocalDate.of(1980, 04, 21));

        // ca.findByYear(2021).forEach(System.out::println);
        us.save(user1);
        try {

            System.out.println(ca.findByTitle("et"));
            // ev.deleteById(1);

        } catch (NoResultException ex) {
            System.out.println("Non trovato");
        }
        em.close();
        emf.close();
    }
}
