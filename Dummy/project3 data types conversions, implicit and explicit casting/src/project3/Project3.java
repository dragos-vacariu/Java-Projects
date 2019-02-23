package project3;
import java.util.Scanner;

public class Project3 {

    public static void main (String[] args) {
       String ValueOne = "1";
       String ValueTwo = "2";
       System.out.printf("ValueOne + ValueTwo = %s\n", ValueOne+ValueTwo);
       //Converting Strings to int:
       int a = Integer.parseInt(ValueOne);
       int b = Integer.parseInt(ValueTwo);
       System.out.printf("a + b = %d\n", a+b);
       float val1 = 22.1f, val2 = 25.4f;
       //TypeCasting:
       a = (int)val1; // a gets the integer part of the floating number val1;
       b = (int)val2; // b gets the integer part of the floating number val2;
       System.out.printf("The value of a is: %d\nThe value of b is: %d\n", a, b);
       //Implicitly casting = casting that is made automatically by the compiler:
       val2 = 15; // so in this case the integer value 15 will be casted into a floating point
       //value, 15.00000, this is done automatically by the compiler, so it's implicit casting.
       
       //Explicitly casting = casting that is done by the programmer, because it cannot be done, 
       //automatically by the compiler.
       a = (int) 22.5; // in this case 22.5 will became 22, (only the integer part of the floating value will
       //be stored to int a);
       
       //INTERESTING STUFF:
       val2 = 20 / 15; // integer / integer will result an integer.
       System.out.printf("The value of division is: %f\n", val2); // this will output the value: 1, even if
       //20/15 is 1.33333333, and even if it is stored in a float.
       
       //FOR THE RESULT TO BE A FLOAT AT LEAST ONE OF THOSE NUMBERS NEEDS TO BE CASTED OR CONVERTED TO FLOAT:
       val2 = 20 / (1.0f * 15); // solution one for casting (1.0 * 15 will be converted to float implicitly).
       System.out.printf("The value of division after casting is: %f\n", val2);
       val2 = 25 / (float) a; // a is explicitly casted to float, so int divided by float will generate a float.
       System.out.printf("The value after explicitly casting is: %f\n", val2);
       System.out.printf("Press any key to terminate!\n");
       Scanner myscanner = new Scanner(System.in);
       myscanner.next();
    }
    
}
