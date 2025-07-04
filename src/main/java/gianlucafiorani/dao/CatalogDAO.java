package gianlucafiorani.dao;

import gianlucafiorani.entities.Book;
import gianlucafiorani.entities.Catalog;
import gianlucafiorani.entities.Magazine;
import gianlucafiorani.entities.Rent;
import gianlucafiorani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class CatalogDAO {
    private final EntityManager entityManager;

    public CatalogDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Catalog newCatalog) {
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(newCatalog);
        transaction.commit();
        System.out.println("L'elemento per il catalogo " + newCatalog.getCodeISBN() + " è stato creato correttamente!");
    }

    public Catalog findByISBN(String isbn) {
        TypedQuery<Catalog> query = entityManager.createQuery("SELECT c FROM Catalog c WHERE c.codeISBN = :isbn LIMIT 1", Catalog.class);
        query.setParameter("isbn", isbn);
        if (query.getSingleResult() == null) throw new NotFoundException(isbn);
        return query.getSingleResult();
    }

    public Book finBookByISBN(String isbn) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE b.codeISBN = :isbn LIMIT 1", Book.class);
        query.setParameter("isbn", isbn);
        if (query.getSingleResult() == null) throw new NotFoundException(isbn);
        return query.getSingleResult();
    }

    public Magazine findMagazineByISBN(String isbn) {
        TypedQuery<Magazine> query = entityManager.createQuery("SELECT m FROM Magazine m WHERE m.codeISBN = :isbn LIMIT 1", Magazine.class);
        query.setParameter("isbn", isbn);
        if (query.getSingleResult() == null) throw new NotFoundException(isbn);
        return query.getSingleResult();
    }

    public List<Catalog> findByYear(int year) {
        TypedQuery<Catalog> query = entityManager.createQuery("SELECT c FROM Catalog c WHERE c.publicationYear = :year", Catalog.class);
        query.setParameter("year", year);
        return query.getResultList();
    }

    public List<Book> findByAutor(String autor) {
        TypedQuery<Book> query = entityManager.createQuery("SELECT b FROM Book b WHERE LOWER(b.autor) LIKE LOWER (:autor)", Book.class);
        query.setParameter("autor", "%" + autor + "%");
        return query.getResultList();
    }

    public List<Catalog> findByTitle(String title) {
        TypedQuery<Catalog> query = entityManager.createQuery("SELECT c FROM Catalog c WHERE LOWER(c.title) LIKE LOWER (:title)", Catalog.class);
        query.setParameter("title", "%" + title + "%");
        return query.getResultList();
    }

    public List<Rent> findUserRentList(UUID id) {
        TypedQuery<Rent> query = entityManager.createQuery("SELECT r FROM Rent r WHERE r.userId = :id", Rent.class);
        query.setParameter("id", id);
        return query.getResultList();
    }

    public List<Rent> findExpiryRent() {
        TypedQuery<Rent> query = entityManager.createQuery("SELECT r FROM Rent r WHERE r.expiryDate < :now", Rent.class);
        query.setParameter("now", LocalDate.now());
        return query.getResultList();
    }


}
