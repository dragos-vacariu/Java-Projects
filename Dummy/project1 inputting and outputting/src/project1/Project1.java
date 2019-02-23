/*
Comments are just like in C, C# or C++;;
 */
package project1; //this package is like name of the folder.

//IMPORTING PACKAGE:
import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project1 { //this class needs to wear the same name just like the file, any change to this
    //class will produce an error. In java we can have only one class in a file.

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creating a scanner for receiving the input;
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Enter your name: "); //println will print a message and carry the cursor to the next 
        //line
        //Getting the input from the user.
        String myName = myscanner.nextLine();
        //Calling functions:
        System.out.print("Your name is: " + myName + "!\n");
        System.out.print("Hello " + myName + "\n"); // \n works just like in c, c++, c#, it will bring the
        //Using printf just like in C++, or C language:
        System.out.printf("Thank you for joining us: %s!!!\n", myName);
        System.out.printf("Press any key to continue!\n");
        myscanner.next();
        //cursor to the next line.
    }
    
}
