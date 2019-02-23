/*
Properties is a subclass of Hashtable. It is used to maintain lists of values in which the key is a 
String and the value is also a String.

The Properties class is used by many other Java classes. For example, it is the type of object returned 
by System.getProperties( ) when obtaining environmental values.
 */
package project27;

import java.util.Iterator;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Black2
 */
public class Project27 {
    public static void main(String[] args) {
       Properties capitals  = new Properties();
       Set states; //creating a Set variable to store all the keys in the Properties collection.
       String str; //creating a string such that it take the value of the element, and uses to find its 
       //property
       capitals.put("Greece", "Athens");
       capitals.put("United Kingdom", "London");
       capitals.put("Germany", "Berlin");
       
       // Show all states and capitals in hashtable.
        states = capitals.keySet();  // get set-view of keys
        Iterator itr = states.iterator();
      
        while(itr.hasNext()) {
         str = (String) itr.next();
         System.out.printf("The capital of %s is %s\n", str, capitals.getProperty(str));
        }
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
