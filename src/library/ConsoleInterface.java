/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import classes.BookCreator;
import classes.BookReturner;
import classes.HistoryReturner;
import classes.LibHistoryCreator;
import classes.ReaderCreator;
import entity.Book;
import entity.LibHistory;
import entity.Reader;
import interfaces.Manageable;
import java.util.List;

/**
 *
 * @author jvm
 */
public class ConsoleInterface implements Manageable{

    @Override
    public Book createBook() {
        BookCreator bookCreator = new BookCreator();
        return bookCreator.returnNewBook();
    }

    @Override
    public Reader createReader() {
        ReaderCreator readerCreator = new ReaderCreator();
        return readerCreator.returnNewReader();
    }

    @Override
    public LibHistory issueBook(List<Book> books, List<Reader> readers) {
        LibHistoryCreator libHistoryCreator = new LibHistoryCreator();
        return libHistoryCreator.returnNewLibHistory(books, readers);
    }

    @Override
    public LibHistory returnBook(List<LibHistory> libHistories) {
        BookReturner bookReturner  = new BookReturner();
        return bookReturner.returnLibHistory(libHistories);            
    }

    @Override
    public void returnHistory(List<LibHistory> libHistories) {
        HistoryReturner historyReturner = new HistoryReturner();
        historyReturner.printListWhoTookBooks(libHistories);
    }
    
}
