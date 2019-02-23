/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project43;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project43 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
	{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	System.out.print("Enter a string:\n"); 	
	String str; 	 
	str=br.readLine();	
        ArrayList <Character> strings = new ArrayList();
        int j;
        for(int i=0;i<str.length();i++)
        {
            strings.add(str.charAt(i));
        }
        for(int i=0;i<str.length();i++)
            {
                for(j=0;j<str.length();j++)
                {
                   if(strings.get(i)<strings.get(j))
                   {
                       char temp = strings.get(i);
                       strings.set(i, strings.get(j));
                       strings.set(j, temp);
                   }
                }
            }
        str="";
        for(int i=0;i<strings.size();i++)
        {
            str+=strings.get(i);
        }
       System.out.printf("Sorted string: %s\n", str);
        }
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
