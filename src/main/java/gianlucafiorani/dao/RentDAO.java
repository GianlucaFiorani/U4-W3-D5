package gianlucafiorani.dao;

import gianlucafiorani.entities.Rent;
import gianlucafiorani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class RentDAO {
    private final EntityManager entityManager;

    public RentDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Rent newRent) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newRent);
        transaction.commit();
        System.out.println("Il prestito" + newRent.getId() + " è stato creato correttamente!");
    }

    public Rent findById(long id) {
        Rent found = entityManager.find(Rent.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public List<Rent> findUserRentList(UUID id) {
        TypedQuery<Rent> query = entityManager.createQuery("SELECT r FROM Rent r WHERE r.userId = :id AND r.endDate IS NULL", Rent.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Rent> findExpiryRent() {
        TypedQuery<Rent> query = entityManager.createQuery("SELECT r FROM Rent r WHERE r.expiryDate < :now AND r.endDate IS NULL", Rent.class);
        query.setParameter("now", LocalDate.now());
        return query.getResultList();
    }

}
