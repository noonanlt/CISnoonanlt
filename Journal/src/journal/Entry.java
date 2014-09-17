/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package journal;

import java.util.Scanner;

/**
 *
 * @author lnoonan
 * 
 * What is the key for entries? Date or should they be keyed by sequence?
 */
public class Entry {
    Scanner input = new Scanner(System.in);
    private int number;
    private String date;
    private String body;
    public final static String RECORD_LAYOUT="000,00000000,                                                                "; //64 spaces for body
    
    public Entry(int nextEntry){
        number=nextEntry;
        System.out.println("Enter the date (mmddyyyy):");
        date=input.nextLine();
        System.out.println("Begin writing. Press enter when finished.");
        body=input.nextLine();
    }
    
    public String fileOutputString(){
        return date+","+formatStringLength(body,64);
    }
    
    public String formatStringLength(String s, int length){
        return String.format("%1$"+length+ "s", s);
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    
    
}
