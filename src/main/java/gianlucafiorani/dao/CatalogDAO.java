package gianlucafiorani.dao;

import gianlucafiorani.entities.Book;
import gianlucafiorani.entities.Catalog;
import gianlucafiorani.entities.Magazine;
import gianlucafiorani.exceptions.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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

    public Catalog findById(long id) {
        Catalog found = entityManager.find(Catalog.class, id);
        if (found == null) throw new NotFoundException(id);
        return found;
    }

    public Book findBookById(long bookId) {
        Book found = entityManager.find(Book.class, bookId);
        if (found == null) throw new NotFoundException(bookId);
        return found;
    }

    public Magazine findMagazineById(long magId) {
        Magazine found = entityManager.find(Magazine.class, magId);
        if (found == null) throw new NotFoundException(magId);
        return found;
    }
}
