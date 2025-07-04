package gianlucafiorani.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Book extends Catalog {
    private String autor;
    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Book() {
    }

    public Book(long id, String codeISBN, String title, int publicationYear, int pageNumb, String autor, Genre genre) {
        super(id, codeISBN, title, publicationYear, pageNumb);
        this.autor = autor;
        this.genre = genre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "autor='" + autor + '\'' +
                ", genre=" + genre +
                '}';
    }
}
