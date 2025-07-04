package gianlucafiorani.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;


@Entity
@Table(name = "utenti")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "numero_di_tessera")
    private UUID userId;

    @Column(name = "nome", nullable = false)
    private String name;

    @Column(name = "cognome", nullable = false)
    private String surname;

    @Column(name = "data_di_nascita", nullable = false)
    private LocalDate birthday;

    @OneToMany(mappedBy = "borrower")
    private List<Rent> rentList;

    public User() {
    }

    public User(String name, String surname, LocalDate birthday) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
    }

    public UUID getId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "card number=" + userId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
