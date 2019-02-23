package project36;

import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project36 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.printf("Enter a number: ");
        int Number;
        boolean Displayed=false;
        Scanner myscanner = new Scanner(System.in);
        Number = myscanner.nextInt();
        for(int i=1;i<Number/2;i++)
        {
            if(i*i*i==Number)
            {
                Displayed = true;
                System.out.printf("Number %d is the cube of %d\n", Number, i);
            }
        }
        if(!Displayed)
        {
            System.out.printf("Number %d is not a cube!\n", Number);
        }
        myscanner.next();
    }
    
}