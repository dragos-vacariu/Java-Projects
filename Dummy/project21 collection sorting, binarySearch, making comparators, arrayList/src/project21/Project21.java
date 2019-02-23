/*
Using the sort() and binarySearch() Collections functions, creating Comparators, for my classes.
Getting Random numbers inside an integer ArrayList.
*/
package project21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project21 {
    public static void main(String[] args) {
        ArrayList <Integer> myList = new ArrayList();
        Random gen = new Random();
        for(int i=0;i<20;i++)
        {
            myList.add(gen.nextInt(50)+1); //adding a random number between 1 and 50.
        }
        //Printing the ArrayList:
        System.out.printf("The unsorted ArrayList is: \n");
        for(int i:myList)
        {
            System.out.printf("%d ", i);
        }
        System.out.printf("\n");
        //Sorting the ArrayList using the Collections.Sort() function
        Collections.sort(myList, new IntegerComparator()); //passing myList and a comparator;
        System.out.printf("\nThe sorted ArrayList is: \n");
        for(int i:myList)
        {
            System.out.printf("%d ", i);
        }
        System.out.println();
        //Using binary search function:
        //IMPORTANT: In order to use binarySearch function the collection must be sorted before that.
        int found = Collections.binarySearch(myList, 50, new IntegerComparator()); //searching for number 50;
        System.out.printf("The number 50 was %s found!\n", found<0? "not" : "");
        ArrayList<StudentNames> Stu = new ArrayList();
        Stu.add(new StudentNames("Viktor"));
        Stu.add(new StudentNames("Carl"));
        Stu.add(new StudentNames("Adam"));
        //Printing the unsorted list:
        System.out.printf("\nThe unsorted StudentList is: \n");
        for(StudentNames i:Stu)
        {
            System.out.printf("%s ", i.GetName());
        }
        Collections.sort(Stu, new StudentNameComparator());
        //Printing the sorted list:
        System.out.printf("\nThe sorted StudentList is: \n");
        for(StudentNames i:Stu)
        {
            System.out.printf("%s ", i.GetName());
        }
        System.out.println();
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
