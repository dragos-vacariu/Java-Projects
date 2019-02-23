/*
An interface is a reference type in Java. It is similar to class. It is a collection of abstract methods. 
A class implements an interface, thereby inheriting the abstract methods of the interface.

Along with abstract methods, an interface may also contain constants, default methods, static methods, and 
nested types. Method bodies exist only for default methods and static methods.

Writing an interface is similar to writing a class. But a class describes the attributes and behaviors of 
an object. And an interface contains behaviors that a class implements
 */
package project13;

//ONCE THAT A CLASS implement AN INTERFACE THAT CLASS IS OBLIGED TO PROVIDE IMPLEMENTATIONS FOR ALL THE
//METHODS IN THE INTERFACE:
import java.util.Scanner;

//THIS CLASS IS OBLIGED TO PROVIDE IMPLEMENTATIONS FOR ToDoListInterface and ToDoListInterface.Numbers
public class Project13 implements ToDoListInterface, ToDoListInterface.Numbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creating an object of the class:
        Project13 InstanceOfClass = new Project13();
        InstanceOfClass.PrintMessage("This is a function that came from an interface!");
        System.out.printf("Max number is: %d\n", InstanceOfClass.findMax(12, 33, 21));
        Scanner myscanner = new Scanner (System.in);
        myscanner.next();
    }
    
    //IF Project13 class WILL NOT PROVIDE IMPLEMENTATIONS FOR THIS... THE PROGRAM WOULD NOT COMPILE.
    public void PrintMessage(String Message){
        System.out.println(Message);
    }
    public int findMax(int a, int b, int c)
    {
        //USING TERNARY OPERATOR:
        return a>b? a>c? a : c : b>c? b : c;
    }
}
/*
PROPERTIES OF INTERFACES:
An interface is implicitly abstract. You do not need to use the abstract keyword while declaring an 
interface.
Each method in an interface is also implicitly abstract, so the abstract keyword is not needed.
Methods in an interface are implicitly public.

SIMILARITIES BETWEEN INTERFACES AND CLASSES:
An interface can contain any number of methods.
An interface is written in a file with a .JAVA extension, with the name of the interface matching the name 
of the file.
The byte code of an interface appears in a .class file.
Interfaces appear in packages, and their corresponding bytecode file must be in a directory structure that 
matches the package name.

DIFFERENCES BETWEEN INTERFACES AND CLASSES:
You cannot instantiate an interface.
An interface does not contain any constructors.
All of the methods in an interface are abstract.
An interface cannot contain instance fields. The only fields that can appear in an interface must be declared 
both static and final.
An interface is not extended by a class; it is implemented by a class.
An interface can extend multiple interfaces.


*/