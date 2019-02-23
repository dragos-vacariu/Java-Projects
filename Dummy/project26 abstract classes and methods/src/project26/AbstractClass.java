/*
As per dictionary, abstraction is the quality of dealing with ideas rather than events. 
For example, when you consider the case of e-mail, complex details such as what happens as soon as you send 
an e-mail, the protocol your e-mail server uses are hidden from the user. Therefore, to send an e-mail you 
just need to type the content, mention the address of the receiver, and click send.

Likewise in Object-oriented programming, abstraction is a process of hiding the implementation details from 
the user, only the functionality will be provided to the user. In other words, the user will have the 
information on what the object does instead of how it does it.

In Java, abstraction is achieved using Abstract classes and interfaces.
A class which contains the abstract keyword in its declaration is known as abstract class.

Abstract classes may or may not contain abstract methods, i.e., methods without body ( public void get(); )
But, if a class has at least one abstract method, then the class must be declared abstract.
If a class is declared abstract, it cannot be instantiated.
To use an abstract class, you have to inherit it from another class, provide implementations to the abstract 
methods in it.
If you inherit an abstract class, you have to provide implementations to all the abstract methods in it.

 */
package project26;

/**
 *
 * @author Black2
 */
public abstract class AbstractClass {
    private String PersonName;
    private int PersonAge;
    public abstract void PrintMessage(); //abstract functions can only be public.
    //Getters:
    public String GetPersonName()
    {
        return this.PersonName;
    }
    public int GetAge()
    {
        return this.PersonAge;
    }
    public AbstractClass(String Name, int Age)
    {
        this.PersonName = Name;
        this.PersonAge = Age;
    }
    //Setters:
    public void SetAge(int Age)
    {
        this.PersonAge = Age;
    }
    public void SetName(String Name)
    {
        this.PersonName = Name;
    }
    
}
