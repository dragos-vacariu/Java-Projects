/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project35;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project35 {
    public static void main (String[] args)
    {
        System.out.printf("Enter the first character: \n");
        Scanner myscanner = new Scanner (System.in);
        char FirstCh=0,  SecondCh=0;
        FirstCh = myscanner.next().charAt(0);
        System.out.printf("Enter the second character: \n");
        SecondCh = myscanner.next().charAt(0);
        System.out.printf("All the characters between %c and %c are: \n", FirstCh, SecondCh);
       for(int i=(int)FirstCh; i<(int)SecondCh+1;i++)
       {
           System.out.printf("%c  ", (char)i);
       }
       System.out.println();
       myscanner.next();
    }
}
