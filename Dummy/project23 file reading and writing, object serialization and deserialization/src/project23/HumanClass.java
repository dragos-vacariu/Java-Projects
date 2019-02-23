/*
Creating a serializable class.
Serializable is the property of writing an object of this class to a file.
Deserializable is the property of reading an object of this class from a file.
 */
package project23;

import java.io.Serializable;

/**
 *
 * @author Black2
 */
//A class is serializable is it implements the Serializable interface.
public class HumanClass implements Serializable{
    int age;
    String Name;
    public HumanClass(int Age, String NewName)
    {
        this.age = Age;
        this.Name = NewName;
    }
    //Getters:
    public int GetAge()
    {
        return this.age;
    }
    public String GetName()
    {
        return this.Name;
    }
            
}
