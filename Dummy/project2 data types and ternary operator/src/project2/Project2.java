package project2;
//This import here, is like an include directive in C/C++, or like an using directive in C#
//It has the purpose of telling the compiler which functioning you use, and where to find them.
import java.util.Scanner;
public class Project2 { //just like in C# it is mandatory that the main function be contained by a class.
    public static void main(String[] args) {
        //Creating a scanner in order to take the input;
        Scanner myscanner = new Scanner(System.in);
        String Name; //in Java strings needs to be declared using String keyword (with capital S);
        int Age;
        double height=11.1;
        boolean IsFemale; //In Java the bool type got renamed to boolean.
        //In Java a variable cannot be displayed if it doesn't get initialized.
        String gender;
        System.out.printf("Enter you name: ");
        //Creating a scanner for inputting;
        Name = myscanner.nextLine();
        System.out.printf("Enter you age: ");
        Age = myscanner.nextInt(); //if any other data it's entered that cannot be converted into a integer
        //an exception will be thrown.
        System.out.printf("Enter your height: ");
        //if any other type it's entered that cannot be converted into a float, an exception will be thrown.
        height = myscanner.nextDouble();
        //Printing the stored information:
        System.out.printf("Are you a female? (True or False)\n");
        IsFemale = myscanner.nextBoolean();
        
        //Using the ternary operator:
        gender = IsFemale? "Female" : "Male";
        //Printing the information:
        System.out.printf("Hello %s. Your age is %d, and you're %f tall. \n", Name, Age, height);
        System.out.printf("%s, you are a %s!\n", Name, gender);
        //System.out.print(MyByte); => this code is not valid, because the variable MyByte is never
        //initialized so it cannot be displayed.
        System.out.printf("Press any key to terminate!\n");
        myscanner.next();
    }
    
}
/*
DOCUMENTATION ABOUT DATATYPE IN JAVA:
Data Type 	Default Value (for fields)
byte                    0
short                   0
int                     0
long                    0L
float                   0.0f
double          	0.0d
char                    '\u0000'
String (or any object)   null
boolean                 false
*/