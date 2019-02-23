/*
The Dictionary class is an abstract class that defines a data structure for mapping keys to values.
This is useful in cases where you want to be able to access data via a particular key rather than an 
integer index.
Since the Dictionary class is abstract, it provides only the framework for a key-mapped data structure 
rather than a specific implementation.
Given a key and value, you can store the value in a Dictionary object. Once the value is stored, you can 
retrieve it by using its key. Thus, like a map, a dictionary can be thought of as a list of key/value pairs.
The Dictionary class is obsolete. You should implement the Map interface to obtain key/value storage 
functionality.
*/
package project17;

import java.util.Dictionary; //used for dictionary;
import java.util.Scanner; //used for Scanner class;
import java.util.Hashtable; //used for the hashtable;
import java.util.Enumeration; //used for enumeration;

/**
 *
 * @author Black2
 */
public class Project17 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //It can be constructed like this also: Dictionary myDict = new Hashtable();
        Dictionary <Integer, String> myDict = new Hashtable(); //creating a dictionary with Integer Keys, and
        //String Content.
        myDict.put(1, "Alan Walker");
        myDict.put(2, "Adam Lambert");
        myDict.put(3, "Tokio Hotel");
        myDict.put(4, "Deryck Whibley");
        myDict.put(5, "Avril Lavigne");
        Enumeration<Integer> MyKeys = myDict.keys();
        Enumeration<String> MyNames = myDict.elements();
        System.out.printf("Size of Dictionary: %d\n", myDict.size());
        //Using for loop to access dictionary:
        for(int i=0; i<myDict.size(); i++)
        {
            System.out.printf("Name: %s     Key: %s\n", MyNames.nextElement(), MyKeys.nextElement());
        }
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
