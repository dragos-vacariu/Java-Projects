/*
try{} catch{} finally{} blocks is a way that you can trace errors and instead of doing the default exit from
the program you could follow another path.
SINTHAX:
try{ //doing the code that can throw an exception}
catch(//this kind of exception) {//if the exception has been caught, do this code here}
finally{//no matter if there was thrown an exception or not, just do this code here. THIS WILL ALWAYS BE EXECUTED}
 
the finally block is not mandatory. It is possible to have only try and catch blocks.
*/
package project22;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Black2
 */
public class Project22 {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        try{
            System.out.println("Enter an integer: ");
            int number = myscanner.nextInt();
            //This code will run only if the line above doesn't produce an exception.
            System.out.printf("You entered: %d\n\n", number);
            //Throwing a Custom Exception:
            if(number>10||number<0)
            {
                throw new CustomExceptionOutRange();
            }
        }
        //Handle the input mismatch exception:
        catch(InputMismatchException e)
        {
            System.out.println("You didn't entered an integer!\n");
        }
        //Handle the custom exception:
        catch(CustomExceptionOutRange r)
        {
            System.out.println("Your number is out of range!\n");
        }
        //This code gets executed anyhow.
        finally
        {
            System.out.println("Thank you for running this!");
        }
        myscanner.next();
    }
    
}
