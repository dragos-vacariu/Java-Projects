/*
Generics is related to using the correspondant object of a primitive data type as it is for int (primitive) -> 
-> Integer(object), for double(primitive) -> Double(object) etc.

Generic methods are methods that can be called with arguments of different types.
Based on the types of the arguments passed to the generic method, the compiler handles each method 
call appropriately. Following are the rules to define Generic Methods.

This is possible only by using objects, but in Java each data type has an object correspondant. 

The java.lang.Integer class wraps a value of the primitive type int in an object. An object of type Integer 
contains a single field whose type is int.
*/
package project29;

import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project29 {

    public static void main(String[] args) {
        Integer [] myArray = new Integer[] {1,42,13,24,5};
        Character [] myCharArray = new Character[] {'D', 'N', 'C', 'A'};
        printArray(myArray);
        printArray(myCharArray);
        //Using the GenericClass:
        GenericClass <Integer> FirstGeneric_Class = new GenericClass<Integer>();
        FirstGeneric_Class.set(2);
        System.out.printf("Value of GenericClass object: %d\n", FirstGeneric_Class.get());
        //Keep the window opened until a key is pressed:
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    //Creating a generic function:
    public static < E > void printArray( E[] inputArray ) {
      // Display array elements
      for(E element : inputArray) {
         System.out.printf("%s ", element);
      }
      System.out.println();
    }
}
/*
Another example of using generics:
public final class Integer extends Number implements Comparable<Integer>
*/