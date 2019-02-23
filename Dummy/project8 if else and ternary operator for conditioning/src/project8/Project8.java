package project8;

/*
If-else statements are conditional statements that allows the program to execute a block of code
only if the condition is fulfilled.
if(condition_is_true)
{
ENTER HERE;
}
else
{
ENTER HERE;
}
*/

import java.util.Scanner;
public class Project8 {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = myscanner.next();
        System.out.println("Enter your age: ");
        int age = myscanner.nextInt();
        if(age<18)
        {
            System.out.println("You are not an adult!");
        }
        else if(age>18 && age<22)
        {
            System.out.println("You are about to become an adult!");
        }
        else
        {
            System.out.println("You are adult!");
        }
        /*
        The IF-ELSE Block above it is equivalent with the following TERNARY OPERATOR BLOCK:
        */
        System.out.println(age<18? "You are not an adult" : age>18&&age<22? "You are about to became an adult" :
                "You are adult!");
        //there is no difference between if-else statements and ternary operator, they are both the same
        //they can achieve the same goal, they have the same speed. It's just a different way or writing it.
        
        myscanner.next();
        
    }
    
}
