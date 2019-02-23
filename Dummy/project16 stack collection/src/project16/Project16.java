package project16;
/*
Stack is a subclass of Vector that implements a standard last-in, first-out.
Stack only defines the default constructor, which creates an empty stack. Stack includes all the methods 
defined by Vector, and adds several of its own.
A stack has the same properties as a vector, it's dynamic in size, can store objects, so it can hold
any type of data... they get automatically resized to fit the objects pushed in.
*/
import java.util.Scanner; //used for Scanner class;
import java.util.Stack; //used for stack collection;

/**
 *
 * @author Black2
 */
public class Project16 {

    public static void main(String[] args) {
        Stack newStack = new Stack(); //Stack of objects
	Stack<Integer> intStack; //Stack of integers;
        //Adding object on stack...
        newStack.add(5);
        newStack.add(5);
        newStack.add(33);
        newStack.add(135);
        newStack.add(25);
        System.out.printf("The element on top of stack is: %d\n", newStack.peek());
        System.out.printf("The element on bottom of the stack is: %d\n", newStack.firstElement());
        //Stacks have the same methods, fields and functionality as vectors.
        Scanner myscanner = new Scanner (System.in);
        myscanner.next();
    }
    
}
