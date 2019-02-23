/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project40;

import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project40 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int array[][] = new int[3][3];
        int array1[][] =new int[3][3];
        int array2[][] = new int[3][3];

        Scanner scan=new Scanner(System.in);

        for(int i = 0; i < 3; i++) 
        {
            for(int j = 0; j <3; j++) 
            {
                System.out.print("Matrix 1st ["+i+"]["+j+"]: ");
                array[i][j]=scan.nextInt();
            }
         }

        for(int i = 0; i < 3; i++) 
        {
           for(int j = 0; j < 3; j++) 
           {
                System.out.print("Matrix 2nd ["+i+"]["+j+"]: ");
                array1[i][j]=scan.nextInt();
           }
        }
        System.out.println();
        //write your logic here 
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                int k=0;
                array2[i][j]=0;
                while(k<3)
                {
                    array2[i][j] += array[i][k]*array1[k][i];
                    System.out.printf("%d*%d =+ %d\n",array[i][k], array1[k][i],array2[i][j]);
                    k++;
                }    
            }
        }
        System.out.println("\nResult of multiplication of the two matrices:\n");

        for(int i = 0; i < 3; i++) 
        {
           for(int j = 0; j < 3; j++) 
            {
                System.out.print(array2[i][j]+" ");
            }  
           System.out.println();
        }
        //Keep the console open until the next button press.
        scan.next();
    }
}
