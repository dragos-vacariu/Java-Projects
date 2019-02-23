/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project38;

import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project38 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner myscanner = new Scanner (System.in);
        System.out.print("Enter a number: ");
        int Number = myscanner.nextInt();
        int result=1;
        for(int i=1;i<Number+1;i++)
        {
            result*=i;
        }
        System.out.printf("The product of all number from 1 to %d is: %d\n", Number, result);
        Number=0;
        while(result>0)
        {
            Number += result%10;
            result/=10;
        }
        System.out.printf("The sum of all the digits of %d is: %d\n", result, Number);
        //Keep the window opened until the next button pressed.
        myscanner.next();
    }
    
}
