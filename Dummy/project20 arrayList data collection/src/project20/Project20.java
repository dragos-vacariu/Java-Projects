/*
The ArrayList class extends AbstractList and implements the List interface. 
ArrayList supports dynamic arrays that can grow as needed. This gives us a new collection data type that
can be used exactly as Vectors, Lists, Stacks, Dictionaries etc. 
Array lists are created with an initial size. When this size is exceeded, the collection is automatically 
enlarged. When objects are removed, the array may be shrunk.

SINTHAX: (all these sintaxes are correct)
ArrayList al = new ArrayList(); //creates an array list;
ArrayList<Integer> al = new ArrayList(); // creates an int arraylist;
ArrayList<Integer> al = new ArrayList<Integer>(); // creates an int arraylist;

NOTE: TO create an int, double, float arraylist there must be used an object of that class, and for int
the object is Integer, for double the object is Double.

Functions of an ArrayList are similar to functions of a Vector or List, or Stack, or Dictionary, you can 
call Add() function, Remove(), RemoveAt() etc.
*/
package project20;

import java.util.ArrayList; //including this here for ArrayList Collection type.
import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project20 {
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList();
        al.add(22);
        al.add(44);
        al.add(59);
        //Accessing the elements:
        for(int i: al)
        {
            System.out.printf("%d ", i);
        }
        System.out.println();
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
