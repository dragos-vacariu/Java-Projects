/*
Enum is a class, able to store constant values, like int values and string values, for the fields, just like in 
C language or C++ or C#. This can be very useful for example when working with the months of the year and the
user enters 2 and the program needs to know that 2 is actualy february or vice-versa.
Enums cannot be instantiated:
Directions d = new Directions(12); //this is wrong; 
*/
package project18;
import java.util.Scanner;

public class Project18 {
    public static void main(String[] args) {
        //Creating an object of type Directions (which is actually an enum);
        Directions d = Directions.West; 
        System.out.printf("%s is at %d.\n", d, d.GetDegrees());
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    } 
}
