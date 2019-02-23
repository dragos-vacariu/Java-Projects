//The Unit Test Class is located in project/test directory
package project10;
import Students.StudentClass; //this is just my class from the other package
import java.io.BufferedReader; // needed to create BufferedReader object
import java.io.Console; //needed to create a Console object
import java.io.IOException; // needed to create IOException object
import java.io.InputStreamReader; // needed to create InputStreamReader object
import java.util.Scanner; // used for creating a Scanner object
public class Project10 {
    public static void main(String[] args) {
        StudentClass myClass = new StudentClass("Black", 18, 9.6);
        myClass.PrintStudentInfo();
        String HoldValue="0";
        Scanner myscanner = new Scanner (System.in);
        System.out.println("Enter your SCANNER message: ");
        HoldValue = myscanner.nextLine();
        System.out.println("Your SCANNER message is: " + HoldValue);
        System.out.println("Enter a char: ");
        HoldValue = myscanner.next();
        if(HoldValue.length()==1)
        {
            char ch = HoldValue.charAt(0);
            System.out.println("Your char is: " + ch);
        }
        else
        {
            System.out.println("You have entered multiple characters.");
        }
        //OTHER WAYS OF INPUTTING:
        System.out.println("Enter your BufferedREADER message: ");
        //Creating an object of type InputStreamReader
        InputStreamReader inStream = new InputStreamReader(System.in);
        //Creating an object of type BufferedReader
        BufferedReader stdin = new BufferedReader(inStream);
        //IT IS MANDATORY TO USE A TRY{} CATCH {} BLOCK IN ORDER TO GET INPUT.
        try{
            HoldValue = stdin.readLine();
        }
        catch(IOException ioe) //ioe IS AN OBJECT OF TYPE IOEXCEPTION
        { 
            //IF THE EXCEPTION WAS CAUGHT, THE PROGRAM ENTERS HERE:
            ioe.printStackTrace(); // DISPLAY TO THE USER THE MESSAGE FROM EXCEPTION.
        }
        if(HoldValue.compareTo("0")!=0)
        {
            System.out.println("Your BufferedREADER message is: " + HoldValue);
        }
        //Converting the String to Integer:
        System.out.println("Enter an integer value: ");
        try{
            HoldValue = stdin.readLine();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
        int a = Integer.parseInt(HoldValue);
        System.out.println("Here is you integer: " + a);
        
        //A console can be used only when the program is running into the CMD(Command Prompt) Console.
        //Otherwise myconsole will always be null.
        Console myconsole = System.console();
        if(myconsole == null)
        {
            System.out.println ("You are not using a console!");
            return;
        }
        System.out.println("Enter your console message: ");
        HoldValue=myconsole.readLine();
        System.out.println("Console Message: " + HoldValue);
        System.out.println ("Enter a double value: ");
        HoldValue = myconsole.readLine();
        double number = Double.parseDouble(HoldValue);
        HoldValue = myconsole.readLine();
   }
}
