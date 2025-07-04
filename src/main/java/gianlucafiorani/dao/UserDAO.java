package gianlucafiorani.dao;

import gianlucafiorani.entities.User;
import gianlucafiorani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

    public User findById(long id) {
        User found = entityManager.find(User.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }
}
