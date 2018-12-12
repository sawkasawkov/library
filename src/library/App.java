/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import entity.Book;
import entity.LibHistory;
import entity.Reader;
import interfaces.Manageable;
import interfaces.Retentive;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jvm
 */
public class App {
    
    private List<Book> books;
    private List<Reader> readers;
    private List<LibHistory> libHistories;
    private Manageable manager = new ConsoleInterface();
    private Retentive saver = new PersistToDatabase();

    public App() {
       this.books = saver.loadBooks();
       this.readers = saver.loadReaders();
       this.libHistories=saver.loadLibHistoryes();
    }
    
    
    
    public void run(){
        String repeat = "r";
        Scanner scanner = new Scanner(System.in);
        int task;
        do{ 
            System.out.println("Выберите действие:");
            System.out.println("0 - выход из программы");
            System.out.println("1 - добавить книгу в библиотеку");
            System.out.println("2 - добавить нового читателя");
            System.out.println("3 - выдать книгу читателю");
            System.out.println("4 - возврат книги");
            System.out.println("5 - история работы библиотеки");
            
            task = scanner.nextInt();
            switch (task) {
                case 0:
                    repeat="q";
                    saver.freeResources();
                    break;
                case 1:
                    Book book = manager.createBook();
                    if(book != null){
                        books.add(book);
                        saver.saveBook(book); 
                    }
                    break;
                case 2:
                    Reader reader = manager.createReader();
                    if(reader != null){
                        readers.add(reader);
                        saver.saveReader(reader); 
                    }
                    break;
                case 3:
                    LibHistory libHistory = manager.issueBook(books, readers);
                    if(libHistory != null){
                        libHistories.add(libHistory);
                        saver.saveLibHistory(libHistory, false); 
                    }
                    break;   
                case 4:
                    LibHistory lh = manager.returnBook(libHistories);
                    if(lh != null){
                        saver.saveLibHistory(lh, true);
                    }
                    break;
                case 5:
                    manager.returnHistory(libHistories);
                    break; 
                default:
                    System.out.println("Выберите одно из действий!");
            }
            
            
        }while("r".equals(repeat));
        
    }
}
