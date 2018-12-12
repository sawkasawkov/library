/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import entity.LibHistory;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 *
 * @author jvm
 */
public class HistoryReturner {
    public void printListWhoTookBooks(List<LibHistory> libHistories){
        System.out.println("-----Список читателей взявших книги----");
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int countHistories = libHistories.size();
        for(int i=0; i<countHistories; i++){
            LibHistory h = libHistories.get(i);
            if(h.getBookReturn()==null){
                System.out.println(i + 1 + ". "+h.getBook().getBookName() + 
                        ". Читает: " + h.getReader().getName()+
                        " " + h.getReader().getSurname()+
                        ". Взято: " + sdfDate.format(h.getBookIssued()));
            }
        }
    }
}
