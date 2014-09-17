/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package journal;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author lnoonan31918
 */
public class JournalMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap<String,Entry> journal = new HashMap();
        int nextEntry=1;
        String option;
        Scanner input = new Scanner(System.in);
        
        String menu = "Fitness Journal"
                + "\nA)Add a journal entry"
                + "\nV)View all journal entries"
                + "\nX)Exit";
        System.out.println(menu);
        option = input.nextLine().toUpperCase();
        
        while (!option.equalsIgnoreCase("x")) {
                switch (option) {
                    case "A":
                        Entry entry = new Entry(nextEntry);
                        nextEntry++;
                        journal.put(entry.getDate(),entry);
                        break;
                    case "V":
                        break;
                    default:
                        System.err.println("Invalid option");
                }
        }
    }
}
