package project7;

import java.util.Scanner;

/*
Loops: a loop is a sequence of instructions that is continually repeated until a certain condition is reached.
*/
public class Project7 {
    public static void main(String[] args) {
        //Using FOR LOOP for multiplication table:
        System.out.printf("USING FOR LOOP:\n");
        for (int i = 1; i<4; i++) // SINTHAX: for (initialization, condition, incrementation) just like in c, c++, c#
        {
            System.out.printf("Multiplication Table with %d:\n", i);
            for (int j = 1; j<11; j++)
            {
                System.out.printf("%d * %d = %d\n", i, j, i*j);
            }
            System.out.println();
        }
        //Using WHILE LOOP for multiplication table:
        int i=4,j=1;
        System.out.printf("USING WHILE LOOP:\n");
        while(i<7) //SINTHAX: while (condition) just like in c, c++, c#
        {
            System.out.printf("Multiplication Table with %d:\n", i);
            while(j<11)
            {
                System.out.printf("%d * %d = %d\n", i, j, i*j);
                j++;
            }
            System.out.println();
            j=1;
            i++;
        }
        i=7; j=1;
        System.out.printf("USING DO WHILE LOOP:\n");
        do{ //SINTHAX DO{this stuff} while(condition);
            System.out.printf("Multiplication Table with %d:\n", i);
            do{
                System.out.printf("%d * %d = %d\n", i, j, i*j);
                j++;
            }while(j<11);
            System.out.println();
            j=1;
            i++;
        }while(i<10);
        /*
        Nested LOOPS is a term used for one loop inside another.
        */
        int [] arrayC = {1,2,3,4,5,6,7,8,9,10};
        System.out.printf("USING FOREACH LOOP:\nMultiplication Table with 10:\n");
        for (int k : arrayC)
        {
            System.out.printf("10 * %d = %d\n", k, 10*k);
        }
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
/*
DIFFERENCES: WHILE LOOP AND FOR LOOP ARE VERY SIMILAR, DISPITE THAT FOR LOOP USES INITIALIZATION, AND
INCREMENTATION WITHIN ITS DECLARATION, WHILE LOOP DOESN'T
as while sinthax is this: while (condition) {do stuff}, for can be written just the same way
ignoring the initialization part, and incrementation part for(condition){do stuff}

DO WHILE DISPITE FOR AND WHILE LOOPS IT GUARENTEES THAT THE CERTAIN LOOP WILL BE EXECUTED AT LEAST
ONCE, BECAUSE THE EVALUATION OF THE CONDITION IT IS MADE AFTER THE LOOP  CODE BLOCK.

FOREACH LOOP it's used exclusively for collection like arrays, vectors, lists and so on, with
a FOREACH LOOP you can iterate through all the items in that collection and to access them as well.
SINTHAX: for(collection_data_type ITERATOR_NAME : COLLECTION_NAME);
EXAMPLE: if we have an int [] arrayDATA, a foreach loop for that would be: for(int NAME : arrayDATA);
so ITERATOR_NAME can have any name, and it doesn't need to be declared, you just put a name in there
and then you use that name to access each element.
*/