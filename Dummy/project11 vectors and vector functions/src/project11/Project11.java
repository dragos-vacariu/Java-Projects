package project11;
import java.util.Scanner;
import java.util.Vector; //using this for Vector class.
/**
 * AN ARRAY IS A COLLECTION OF DATA OF THE SAME TYPE, WITH FIXED SIZE AND CAPACITY.
 A VECTOR IS A DYNAMIC ARRAY, THAT CAN CHANGE IT's SIZE/CAPACITY, and ITS AUTOMATICALLY CHANGING IT's CAPACITY
 * IN JAVA A VECTOR CAN STORE ANY TYPE OF DATA/OBJECT.
 * A VECTOR OF OBJECTS CAN MIX DIFFERENT TYPES TOGETHER, LIKE INTEGERS AND STRINGS.
 */
public class Project11 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vector myVector = new Vector(3); //creating a vector (of objects by default) of size 3;
        //Creating a vector of integers:
	Vector <Integer> Vector2 = new Vector(); //using the default constructor, this vector will have
        //by default the size 10;
        System.out.printf("The capacity of the myVector before adding elements: %d\n", myVector.capacity());
        System.out.printf("The size of myVector before adding elements: %d\n", myVector.size());
	//A Vector of object can mix different types of data together.
        myVector.add(21);
        myVector.add(55);
        myVector.add(77);
        myVector.add(192);
        myVector.add("Name");
        System.out.printf("The capacity of the myVector after adding 5 elements: %d\n", myVector.capacity());
        System.out.printf("The size of myVector after adding 5 elements: %d\n", myVector.size());
        System.out.printf("The capacity of the Vector2 is: %d\n", Vector2.capacity());
        /*
        THE CAPACITY INCREASES AUTOMATICALLY WHEN IT's EXCEEDING ITS INITIAL VALUE.
        */
        System.out.printf("The index of NAME is: %d\n", myVector.indexOf("Name"));
        //Displaying elements:
        int i = 0;
        //USING FOREACH LOOP TO ITERATE THROUGH THE VECTOR:
        for(Object k : myVector)
        {
           if(i<myVector.indexOf("Name"))
           {
               System.out.printf("vector [%d] = %d\n", i, Integer.parseInt(k.toString()));
           }
           else
           {
               System.out.printf("vector [%d] = %s\n", i, k.toString());
           }
           i++;
        }
        //SOME VECTOR FUNCTIONS:
        Object [] array = myVector.toArray(); //converting vector into array;
        //ITERATE THROUGH ARRAY:
        for(i=0;i<array.length; i++)
        {
            System.out.printf("array[%d] = %s\n", i, array[i].toString());
        }
        myVector.insertElementAt("NAME2", 3); //insert element at index 3;
        myVector.removeElementAt(4); // remove element at index 4;
        i=0;
        //USING WHILE TO ITERATE THROUGH VECTOR:
        while(i<myVector.size())
        {
            System.out.printf("myVector[%d] = %s\n", i, myVector.elementAt(i).toString());
            i++;
        }
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
