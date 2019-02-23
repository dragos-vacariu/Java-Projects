/*
Java is not call by reference it is call by value only. But all variables of object type are actually pointers.
Actually these are the only pointers that exists in JAVA.
So if you use a Mutable Object you will see the behavior you want.
 */
package project30;

import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project30 {

    public int member=1;
    
    public static void main(String[] args) {
        
        int a = 50;
        System.out.printf("Value of a before: %d\n", a);
        AddTwoToIt(a);
        System.out.printf("Value of a after: %d\n", a);
        Integer m = new Integer(3);
        System.out.printf("Value of m before: %d\n", m);
        AddTenToIt(m);
        
        //THESE ARE WORKING:
        System.out.printf("Value of m after: %d\n", m);
        Project30 object = new Project30();
        System.out.printf("Value of member before: %d\n", object.member); //not working because it wasn't
        //initialized:
        AddTwentyToIt(object);
        System.out.printf("Value of member before: %d\n", object.member);
        int [] c = new int [1];
        c[0]=1;
        System.out.printf("Value of c before: %d\n", c[0]);
        AddFiveToIt(c);
        System.out.printf("Value of c after: %d\n", c[0]);
        
        //Keep this window opened until the next key press.
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
        
    }
    //THESE TWO METHODS WON'T CHANGE A THING UNLESS THEY RETURN THE MODIFIED VALUE WHICH IS NOT THE CASE:
    public static void AddTwoToIt(int a)
    {
        a+=2;
    }
    public static void AddTenToIt(Integer m)
    {
        m+=10;
    }
    //THIS IS ACTUALLY PASS BY REFERENCE IN JAVA. BUT IS NOT QUITE A PASS BY REFERENCE BY A PASS BY OBJECT.
    //IN WHICH OBJECTS ARE REFERENCED.
    public static void AddTwentyToIt(Project30 m)
    {
        m.member = 22;
    }
    //MAKING USE OF ARRAY PROPERTY:
    public static void AddFiveToIt(int [] c)
    {
        c[0]+=5;
    }
}
