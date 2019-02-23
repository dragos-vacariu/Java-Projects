/*
The can be multiple classes in the same package. A package is actually the folder/directory
that contains the .java files. All the packages are actually created inside the directory: \project6\src
SO every folder inside the src directory is a package.

In java each class must have its own .java file. There cannot be multiple classes in the same file,
unless some of them are inner classes (class inside another class).

Encapsulation is one of the four fundamental OOP concepts. The other three are inheritance, polymorphism, and abstraction.

Encapsulation in Java is a mechanism of wrapping the data (variables) and code acting on the data (methods) together as a 
single unit. In encapsulation, the variables of a class will be hidden from other classes, and can be accessed only through 
the methods of their current class. Therefore, it is also known as data hiding.
*/

//PACKAGE needs to be written before the IMPORTS;
package project6;
import java.util.Random;
import java.util.Scanner;

public class DiceClass {
    int Faces;
    int StartingValue;
    //Creating a constructor for the class;
    public DiceClass(int numberOfFaces, int FirstValueOnDie) //A constructor is like a method/functions that is used
            //to initialized all the ValueType Variables inside the class. A constructor has the same name as
            //the class, and it doesn't need a return type, because it's not meant to return anything.
    {
        Faces = numberOfFaces;
        StartingValue = FirstValueOnDie;
    }
    //Public Functions/Methods:
    private int RollTheDice()
    {
        //Creating a random generator seeded with time (by default);
        Random newRandomGenerator = new Random(); // seeded by time;
        //Get a random number between 0 and Faces's Value;
        int ShownValue = newRandomGenerator.nextInt(Faces);
        //Increase that value with the StartingValue
        ShownValue+=StartingValue;
        //Return the result
        return ShownValue;
    }
    public void PrintTheDieValue()
    {
        Scanner myscanner = new Scanner(System.in);
        String UserInput = "DEFAULT";
        while(UserInput.toUpperCase().compareTo("X")!=0)
        {
            if(UserInput.toUpperCase().compareTo("DEFAULT")!=0 && UserInput.toUpperCase().compareTo("A")!=0)
            {
                System.out.printf("Please enter only \"A\" or \"X\n");
            }
            else
            {
              System.out.printf("Press \"A\" to roll the dice, OR press \"X\" to quit!\n");
            }
            UserInput = myscanner.next();
            if(UserInput.toUpperCase().compareTo("A")==0)
            {
                System.out.printf("The value from dice is: %d\n", RollTheDice());
            }
        }
    }
    //ENCAPSULATIONS IS THE GOOD USE OF GETTERS AND SETTERS FOR GETTING OR SETTING THE VALUE OF
    //A FIELD INSIDE THE CLASS.
    /*
    CONVETIONS:
    -good programmer use private fields for a class. (A field is a variable declared in the class)
    -good programmers use at least a constructor for a class. (And that constructor is used to initialize the
    fields.)
    -good programmers use encapsulation for controling the value that get in or get out from the fields
    -a method inside a class is also called property of the class, there can be public or private properties
    */
}
