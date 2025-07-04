package gianlucafiorani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Rent {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User borrower;

    @OneToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Catalog borrowItem;


    @Column(name = "inizio_prestito")
    private LocalDate startDate;

    @Column(name = "scadenza_prestito")
    private LocalDate expiryDate;

    @Column(name = "restituzione_prestito")
    private LocalDate endDate;

    public Rent() {
    }

    public Rent(User borrower, Catalog borrowItem) {
        this.borrower = borrower;
        this.borrowItem = borrowItem;
        this.startDate = LocalDate.now();
        this.expiryDate = LocalDate.now().plusDays(30);
    }

    public Rent(User borrower, Catalog borrowItem, LocalDate endDate) {
        this.borrower = borrower;
        this.borrowItem = borrowItem;
        this.startDate = LocalDate.now();
        this.expiryDate = LocalDate.now().plusDays(30);
        this.endDate = endDate;
    }

    public long getId() {
        return id;
    }


    public User getBorrower() {
        return borrower;
    }

    public void setBorrower(User borrower) {
        this.borrower = borrower;
    }

    public Catalog getBorrowItem() {
        return borrowItem;
    }

    public void setBorrowItem(Catalog borrowItem) {
        this.borrowItem = borrowItem;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Rent{" +
                "id=" + id +
                ", borrower=" + borrower +
                ", borrowItem=" + borrowItem +
                ", startDate=" + startDate +
                ", expiryDate=" + expiryDate +
                ", endDate=" + endDate +
                '}';
    }
}
