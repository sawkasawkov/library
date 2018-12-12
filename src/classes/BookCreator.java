/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.Book;
import java.util.Scanner;

/**
 *
 * @author jvm
 */
public class BookCreator {
    public Book returnNewBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----Добавление новой книги-----");
        Book book = new Book();
        System.out.println("Название книги:");
        book.setBookName(scanner.nextLine());
        System.out.println("ISBN книги:");
        book.setIsbn(scanner.nextLine());
        System.out.println("Автор книги:");
        book.setAuthor(scanner.nextLine());
        System.out.println("Год издания книги:");
        book.setYearPublishing(scanner.nextInt());
        System.out.println(book.toString());
        System.out.println("Для добавления введите любой символ\nДля отмены наберите -1");
        String yes = "";
        yes = scanner.next();
        if(!"".equals(yes)){
            System.out.println("----Книа не добавлена----");
            return null;
        }else{
            System.out.println("----Книга добавлена----");
            return book;
        }
    }
}
