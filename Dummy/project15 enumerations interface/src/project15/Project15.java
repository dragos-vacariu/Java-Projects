/*
The Enumeration interface defines the methods by which you can enumerate (obtain one at a time) the elements 
in a collection of objects.
Enumerations must not be confused with enums. They are different types, different objects, with different
utility.
 */
package project15;

import java.util.Enumeration; //used for enumerations;
import java.util.Scanner; // used for scanner class;
import java.util.Vector; //used for vectors;

/**
 *
 * @author Black2
 */
public class Project15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	//Creating an enumeration of objects;
        Enumeration Days; //enumerations cannot be initialized with an object of type enumeration;
	//because enumeration is abstract interface.
	Enumeration <Integer> intEnumeration; //enumeration of integers;
        Vector myVect = new Vector (3); //vector of objects
        myVect.add("Sunday");
        myVect.add("Monday");
        myVect.add("Friday");
        Days = myVect.elements(); //the elements from vector gets transfered to enumeration.
        while(Days.hasMoreElements())
        {
            System.out.println(Days.nextElement());
        }
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
