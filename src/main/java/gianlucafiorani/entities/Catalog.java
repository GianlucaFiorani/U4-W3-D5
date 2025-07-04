package gianlucafiorani.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Catalog {
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "codice_ISBN", nullable = false)
    private String codeISBN;

    @Column(name = "titolo")
    private String title;

    @Column(name = "anno_pubblicazione")
    private int publicationYear;

    @Column(name = "numero_pagine")
    private int pageNumb;

    @OneToOne(mappedBy = "borrowItem")
    private Rent rent;

    public Catalog() {
    }

    public Catalog(String codeISBN, String title, int publicationYear, int pageNumb) {
        this.codeISBN = codeISBN;
        this.title = title;
        this.publicationYear = publicationYear;
        this.pageNumb = pageNumb;
    }

    public long getId() {
        return id;
    }

    public Rent getRent() {
        return rent;
    }

    public String getCodeISBN() {
        return codeISBN;
    }

    public void setCodeISBN(String codeISBN) {
        this.codeISBN = codeISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public int getPageNumb() {
        return pageNumb;
    }

    public void setPageNumb(int pageNumb) {
        this.pageNumb = pageNumb;
    }

    @Override
    public String toString() {
        return
                "codeISBN='" + codeISBN + '\'' +
                        ", title='" + title + '\'' +
                        ", publicationYear=" + publicationYear +
                        ", pageNumb=" + pageNumb;
    }
}
