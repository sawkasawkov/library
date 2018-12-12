/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jvm
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    private String isbn;
    private String author;
    private Integer yearPublishing;

    public Book() {
    }

    public Book(Long id, String bookName, String isbn, String author, Integer yearPublishing) {
        this.id = id;
        this.bookName = bookName;
        this.isbn = isbn;
        this.author = author;
        this.yearPublishing = yearPublishing;
    }

    public Integer getYearPublishing() {
        return yearPublishing;
    }

    public void setYearPublishing(Integer yearPublishing) {
        this.yearPublishing = yearPublishing;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.bookName);
        hash = 11 * hash + Objects.hashCode(this.isbn);
        hash = 11 * hash + Objects.hashCode(this.author);
        hash = 11 * hash + Objects.hashCode(this.yearPublishing);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book) obj;
        if (!Objects.equals(this.bookName, other.bookName)) {
            return false;
        }
        if (!Objects.equals(this.isbn, other.isbn)) {
            return false;
        }
        if (!Objects.equals(this.author, other.author)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.yearPublishing, other.yearPublishing)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Book{" + "id=" + id + ", bookName=" + bookName + ", isbn=" + isbn + ", author=" + author + ", yearPublishing=" + yearPublishing + '}';
    }
    
    
}
