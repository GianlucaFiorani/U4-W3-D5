package gianlucafiorani;

import com.github.javafaker.Faker;
import gianlucafiorani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("catalogo");

    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();

        Faker faker = new Faker();


        try {


            // ev.deleteById(1);

        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        em.close();
        emf.close();
    }
}
