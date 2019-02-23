package project5;
import java.util.Scanner;
/*
In JAVA each class must have it's own file, there cannot be multiple classes in the same file.
 * @author Black2
 */
public class Project5 {
    //THE main method needs to be static, needs to be public and needs to take a String[] as argument:
    public static void main(String[] args) {
        System.out.printf("2 to the power 5 is: %d\n", RaiseToPower(2, 5));
        System.out.printf("5 to the power 3 is: %d\n", RaiseToPower(5,3));
        System.out.printf("Max between 2,3 and 11 is: %d\n", GetMaxNumber(2,3,11));
        System.out.printf("Max between 25,62 and 34 is: %d\n", GetMaxNumber(25,62,34));
        //Calling the UNSTATIC FUNCTION:
        Project5 myProject = new Project5();
        myProject.PrintMessage("This is an UNSTATIC FUNCTION!");
        Scanner myscanner = new Scanner(System.in);
        System.out.printf("Press any key to quit!\n");
        myscanner.next();
    }
    
    //Creating functions/methods:
    public static int RaiseToPower(int baseNumber, int Exponent)
    {
        int temp = baseNumber;
        for (int i=1; i<Exponent; i++)
        {
            baseNumber*=temp;
        }
        return baseNumber;
    }
    public static int GetMaxNumber(int number1, int number2, int number3)
    {
        //Using Ternary Operator:
        int MaxValue = number1>number2? number1>number3? number1 
                :number3 :number2>number3? number2: number3;
        /*
        THIS TERNARY OPERATOR IS EQUIVALENT TO AND IF ELSE STATEMENT:
        if(number1>number){
            if(number1>number3){MaxValue = number1;}
            else MaxValue = number3;  
        }
        else{
            if(number2>number3){MaxValue = number2;}
            else MaxValue = number3;  
        }
        */
        return MaxValue;
    }
    /*
    In JAVA just like in C# a static method doesn't require creating an instance of the class, in order
    to call the function, so these 2 functions can be called without any instances of this class.
    In JAVA a function or a method needs to be inside a class, need to be contained by a class.
    In JAVA a static function is a member that has the same value for all the instances of the class
    because there will exist only one copy of this, shared between all the instances of the class.
    */
    
    //Creating an UNSTATIC funtion:
    public void PrintMessage(String message)
    {
        System.out.println(message);
    }
    /*
    The difference between arguments and parameters:
    ->ARGUMENT = the value that is passed when calling a function;
    -PARAMETER = the variable that a function uses to take the required information for its work.
    Actually a parameter and an argument its the same thing, but when calling a function is called argument
    when creating a function is called parameter, the argument is the value of the parameter. The value passed
    in as argument, gets stored into the parameter variable.
    */
}
