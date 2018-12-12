/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import entity.LibHistory;
import entity.Reader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jvm
 */
public class LibHistoryCreator {
    public LibHistory returnNewLibHistory(List<Book> books, List<Reader> readers){
        System.out.println("-----Выдача книги читателю------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Список книг: ");
        int countBooks = books.size();
        for(int i = 0; i<countBooks; i++){
            System.out.println(i+1+". "+books.get(i).getBookName());
        }
        System.out.println("Список читателей: ");
        int countReaders = readers.size();
        for(int i = 0; i<countReaders; i++){
            System.out.println(i+1+". "+readers.get(i).getName()+" "+readers.get(i).getSurname());
        }
        System.out.println("Выберите номер книги:");
        System.out.println("(0 для выхода)");
        int numberBook = scanner.nextInt();
        if(numberBook < 1) return null;
        Book book = books.get(numberBook-1);
        System.out.println("Выберите номер читателя:");
        System.out.println("(-1 для выхода)");
        int numberReader = scanner.nextInt();
        if(numberBook < 0) return null;
        Reader reader = readers.get(numberReader-1);
        Calendar c = new GregorianCalendar();
        LibHistory libHistory = new LibHistory(null, book, reader, c.getTime(), null);
        return libHistory;
    }
}
