package project9;

import java.util.Scanner;

/*A switch statement is like a full block of if, else if, else statements, dispite that is operating faster.
*/
public class Project9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = myscanner.next();
        System.out.println("Enter your age: ");
        int age = myscanner.nextInt();
        switch(age)
        {
            case 18: { //this if equivalent to if(age==18)
                System.out.println("You are eighteen years old!");
                //it is important to have a break statement here, in case that age==18,to stop from going to
                //next case
                break;
            }
            case 19: { //this if equivalent to if(age==19)
                System.out.println("You are nineteen years old!");
                break;
            }
            case 20: { //this if equivalent to if(age==20)
                System.out.println("You are twenty years old!");
                break;
            }
            default: //the default case is like an else statement, it assures you that one message will appear
                //in case that none of the cases above matches.
            {
                System.out.println("I can't find your age here!");
                break;
            }
        }
        myscanner.next();
    }
    
}
/*
The reason why switch is faster than if/else statements and ternary operator is that... a switch doesn't
evaluate all the cases, it goes exacty to the right case. Example if age=20, the case 18 and case 19 will be
skipped.
*/