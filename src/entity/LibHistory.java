/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author jvm
 */
@Entity
public class LibHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne(cascade = CascadeType.MERGE,orphanRemoval = true)
    private Book book;
    @OneToOne(cascade = CascadeType.MERGE,orphanRemoval = true)
    private Reader reader;
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookIssued;
    @Temporal(TemporalType.TIMESTAMP)
    private Date bookReturn;

    public LibHistory() {
    }

    public LibHistory(Long id, Book book, Reader reader, Date bookIssued, Date bookReturn) {
        this.id = id;
        this.book = book;
        this.reader = reader;
        this.bookIssued = bookIssued;
        this.bookReturn = bookReturn;
    }

    public Date getBookReturn() {
        return bookReturn;
    }

    public void setBookReturn(Date bookReturn) {
        this.bookReturn = bookReturn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public Date getBookIssued() {
        return bookIssued;
    }

    public void setBookIssued(Date bookIssued) {
        this.bookIssued = bookIssued;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.book);
        hash = 67 * hash + Objects.hashCode(this.reader);
        hash = 67 * hash + Objects.hashCode(this.bookIssued);
        hash = 67 * hash + Objects.hashCode(this.bookReturn);
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
        final LibHistory other = (LibHistory) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.book, other.book)) {
            return false;
        }
        if (!Objects.equals(this.reader, other.reader)) {
            return false;
        }
        if (!Objects.equals(this.bookIssued, other.bookIssued)) {
            return false;
        }
        if (!Objects.equals(this.bookReturn, other.bookReturn)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        if(bookReturn != null)
           return "LibHistory{" + "id=" + id + ", book=" + book.getBookName() + ", reader=" + reader.getName() + " " + reader.getSurname() + ", \nbookIssued=" + bookIssued.toString() + ", bookReturn=" + bookReturn.toString() + '}';
        else
           return "LibHistory{" + "id=" + id + ", book=" + book.getBookName() + ", reader=" + reader.getName() + " " + reader.getSurname() + ", \nbookIssued=" + bookIssued.toString() + ", bookReturn= " + '}';
 
    }
    
    
}
