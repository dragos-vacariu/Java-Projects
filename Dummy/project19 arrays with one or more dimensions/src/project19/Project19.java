/*
Arrays in Java are just like in C, C++ or C#. A fixed size collection data type, that is used to store
a certain number of variables of the same data type.
As object oriented programming in JAVA uses classes for any data types, and any data type derives from object 
class, making an array of type object class it will allow the storage of any type: float, int, long etc.
Array is type structure.
*/


package project19;

import java.util.Scanner;

public class Project19 {

    public static void main(String[] args) {
        //THESE ARE CALLED PARRALEL  ARRAYS BECAUSE ARE USED TOGETHER TO STORE THE INFORMATION THAT A CLASS
        //USUALLY IS SET TO DO.
        //IN OOP new KEYWORD MEANS DYNAMIC MEMORY ALLOCATION (On Heap). AND COLLECTIONS CAN BE ONLY STORED ON
        //HEAP (DYNAMICALLY).
        int [] Array = new int[] {22,33,44,55};
        String [] Names = new String [] {"Dragos", "Edy", "Solomon", "Gregorian"};
        System.out.printf("Age\tName\n\n");
        for(int i=0;i<Array.length;i++)
        {
            System.out.printf("%d\t%s\n", Array[i], Names[i]);
        }
        //Creating an array of objects of type Students.
        Students [] Group5307 = new Students[4];
        //Filling up the array:
        Group5307[0] = new Students ("Alan", 84);
        Group5307[1] = new Students ("Katerine", 78);
        Group5307[2] = new Students ("Joe", 63);
        Group5307[3] = new Students ("Richard", 91);
        //Header table:
        System.out.printf("\n\nGrade\tName\n\n");
        for(int i=0;i<Group5307.length;i++)
        {
            System.out.printf("%d\t%s\n", Group5307[i].GetGrade(),  Group5307[i].GetName());
        }
        //MULTI-DIMENSIONAL ARRAYS:
        System.out.println("\nPrinting the matrix:");
        int [][] MultiArray = new int [2][3];
        MultiArray[0][0] = 12;
        MultiArray[0][1] = 23;
        MultiArray[0][2] = 42;
        MultiArray[1][0] = 142;
        MultiArray[1][1] = 155;
        MultiArray[1][2] = 623;
        for(int i=0;i<2;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.printf("%d\t", MultiArray[i][j]);
            }
            System.out.printf("\n");
        }
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
