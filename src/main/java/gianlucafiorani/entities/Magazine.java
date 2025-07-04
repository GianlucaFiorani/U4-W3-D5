package gianlucafiorani.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Magazine extends Catalog {
    @Enumerated(EnumType.STRING)
    private Periodicity periodicity;

    public Magazine() {
    }

    public Magazine(String codeISBN, String title, int publicationYear, int pageNumb, Periodicity periodicity) {
        super(codeISBN, title, publicationYear, pageNumb);
        this.periodicity = periodicity;
    }

    public Periodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(Periodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                super.toString() +
                ", periodicity=" + periodicity +
                '}';
    }
}
