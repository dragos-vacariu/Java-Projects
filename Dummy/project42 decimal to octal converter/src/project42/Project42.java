/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project42;

import java.util.Scanner;

public class Project42 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int number;
        Scanner myscanner = new Scanner (System.in);
        System.out.printf("Enter a decimal number: ");
        number = myscanner.nextInt();
        int octal=0;
        int digit;
        int factor = 1;
        int temp = number;
        while (number>0)
        {
            digit = number & 0b111;
            digit*=factor;
            number=number>>3;
            factor*=10;
            octal +=digit;
        }
        System.out.printf("%d in octal is: %d\n", temp, octal);
        //keep the console opened until the next button press.
        myscanner.next();
    }
    
}
