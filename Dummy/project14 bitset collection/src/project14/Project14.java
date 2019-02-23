/*
The BitSet class creates a special type of array that holds bit values. The BitSet array can increase in size 
as needed. This makes it similar to a vector of bits. This is a legacy class but it has been completely 
re-engineered in Java 2, version 1.4.
*/
package project14;

import java.util.BitSet; //used for BitSet Collection;
import java.util.Scanner; //used for Scanner Class;

/**
 *
 * @author Black2
 */
public class Project14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BitSet FlagCollection = new BitSet(3);
        FlagCollection.set(1);
        FlagCollection.set(2);
        System.out.printf("The value of first bit is: %b\n", FlagCollection.get(0));
        System.out.printf("The value of second bit is: %b\n", FlagCollection.get(1));
        System.out.printf("The value of third bit is: %b\n", FlagCollection.get(2));
        System.out.println("\nUsing BitSet in loops:\n");
        //USING BitSet in FOR LOOP
        for (int i =0; i<7; i++)
        {
            if(i%2==0)
            {
                FlagCollection.set(i);
            }
        }
        FlagCollection.size();
        //USING BitSet in WHILE LOOP
        int i=0;
        while (i < FlagCollection.length())
        {
            System.out.printf("The value of %d bit is: %b\n",i ,FlagCollection.get(i));
            i++;
        }
        Scanner myscanner = new Scanner (System.in);
        myscanner.next();
    }
    
}
