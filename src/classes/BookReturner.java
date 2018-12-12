/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.LibHistory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jvm
 */
public class BookReturner {
    public LibHistory returnLibHistory(List<LibHistory> libHistories){
        try{
            System.out.println("-----Возврат книги-----");
            LibHistory libHistory = new LibHistory();
            Scanner scanner = new Scanner(System.in);
            int countLibHistories = libHistories.size();
            for (int i = 0; i < countLibHistories; i++) {
                LibHistory history = libHistories.get(i);
                System.out.println(i+1+". "+history.getReader().getName()
                        +" "+history.getReader().getSurname()
                        +": "+history.getBook().getBookName());
            }
                System.out.println("Выберите номер строки с возвращаемой книгой: ");
                System.out.println("Чтобы ничего не делать наберите -1");
                int numHistory = scanner.nextInt();
                if(numHistory < 0) return null;
                libHistory = libHistories.get(numHistory-1);
                libHistories.remove(libHistory);
                Calendar c = new GregorianCalendar();
                libHistory.setBookReturn(c.getTime());
            return libHistory;
        }catch(Exception e){
            return null;
        }
    }
}
