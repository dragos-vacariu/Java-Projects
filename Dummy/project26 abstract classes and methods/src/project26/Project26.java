/*
Using abstract classes, documentation on the other file!
 */
package project26;

import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project26 extends AbstractClass //at this point I am obliged to provide implementation for the
        //abstract method called PrintMessage();
{
    //Calling the constructer of the parentClass.
    public Project26()
    {
        super("Adam", 22);
    }
    public static void main(String[] args) {
        System.out.println("The characteristics of the abstract class: \n");
        Project26 object = new Project26();
        object.PrintMessage();
        System.out.printf("Name: %s\tAge: %d\n", object.GetPersonName(), object.GetAge());
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    @Override
    public void PrintMessage()
    {
        System.out.printf("This is the implementation for the abstract method!\n");
    }
}
