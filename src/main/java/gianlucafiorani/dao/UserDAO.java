package gianlucafiorani.dao;

import gianlucafiorani.entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.UUID;

public class UserDAO {
    private final EntityManager entityManager;

    public UserDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(User newUser) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newUser);
        transaction.commit();
        System.out.println("L'utente" + newUser.getId() + " è stato creato correttamente!");
    }

    public User findById(String id) {
        User found = entityManager.find(User.class, UUID.fromString(id));
        //if (found == null) throw new NotFoundException(id);
        return found;
    }
}
