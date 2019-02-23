/*
Hashtable was part of the original java.util and is a concrete implementation of a Dictionary.
 */
package project28;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class Project28 {

    public static void main(String[] args) {
        Hashtable balance = new Hashtable();
        //These fields are required:
        Enumeration names;
        String str;
        int value;
        //Adding items to the harshtable.
        balance.put("Alan", 1);
        balance.put("Carl", 2);
        balance.put("Darren", 5);
        //Getting the content out into an enumeration:
        names = balance.keys();
        while(names.hasMoreElements()) {
            str = (String) names.nextElement();
             System.out.println(str + ": " + balance.get(str));
        }
        System.out.println();
        value = (int)balance.get("Darren");
        System.out.printf("Darren's key: %d\n", value);
        //Puttin another key to Darren:
        balance.put("Darren", 10);
        System.out.printf("Darren's new key: %d\n", balance.get("Darren"));
        
        //Getting the content out into an enumeration:
        names = balance.keys();
        System.out.println();
        while(names.hasMoreElements()) {
            str = (String) names.nextElement();
             System.out.println(str + ": " + balance.get(str));
        } 
        //Waiting for a button pressed:
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
