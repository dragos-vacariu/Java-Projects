/*
This is the way of creating Custom Exceptions. You just create a class of the name you want and it make it
extends the Exception class.

IMPLEMENTS vs EXTENDS:
extends is for extending a class, for inheritance from another class.
implements is for implementing an interface.

Inheritance, extends the functionality of a class into another.
Interfaces, exhibits the same characteristics to multiple classes.

The difference between an interface and a regular class is that in an interface you can not implement any 
of the declared methods. Only the class that "implements" the interface can implement the methods. 
The C++ equivalent of an interface would be an abstract class (not EXACTLY the same but pretty much).

Also java doesn't support multiple inheritance for classes. This is solved by using multiple interfaces.
*/
package project22;

/**
 Making this class inherits from Exception class.
 */
public class CustomExceptionOutRange extends Exception{
    
}
