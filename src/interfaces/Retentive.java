/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Book;
import entity.LibHistory;
import entity.Reader;
import java.util.List;

/**
 *
 * @author jvm
 */
public interface Retentive {
    public void saveBook(Book book);
    public void saveReader(Reader reader);
    public void saveLibHistory(LibHistory libHistory,boolean update);
    public List<Book> loadBooks();
    public List<Reader> loadReaders();
    public List<LibHistory> loadLibHistoryes();
    public void freeResources();
}
