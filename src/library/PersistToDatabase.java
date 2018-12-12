/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import entity.Book;
import entity.LibHistory;
import entity.Reader;
import interfaces.Retentive;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author jvm
 */
public class PersistToDatabase implements Retentive{

    private final EntityManager em;
    private final EntityTransaction tx;
    
    public PersistToDatabase() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    @Override
    public void freeResources() {
        if(em != null) em.close();
        
    }
    
    @Override
    public void saveBook(Book book) {
        tx.begin();
        em.persist(book);
        tx.commit();
    }

    @Override
    public void saveReader(Reader reader) {
        tx.begin();
        em.persist(reader);
        tx.commit();
    }

    @Override
    public void saveLibHistory(LibHistory libHistory, boolean update) {
        tx.begin();
        if(update){
            em.merge(libHistory);
        }else{
            em.persist(libHistory);
        }
        tx.commit();
    }

    @Override
    public List<Book> loadBooks() {
        try {
            return em.createQuery("SELECT b FROM Book b").getResultList();
        } catch (Exception e) {
            return new ArrayList<Book>();
        }
    }

    @Override
    public List<Reader> loadReaders() {
        try {
            return em.createQuery("SELECT r FROM Reader r").getResultList();
        } catch (Exception e) {
            return new ArrayList<Reader>();
        }
    }

    @Override
    public List<LibHistory> loadLibHistoryes() {
        try {
            return em.createQuery("SELECT h FROM libHistory h").getResultList();
        } catch (Exception e) {
            return new ArrayList<LibHistory>();
        }
    }
    
}
