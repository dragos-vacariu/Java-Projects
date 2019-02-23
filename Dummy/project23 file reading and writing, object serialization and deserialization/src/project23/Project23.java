/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project23;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project23 {

    /**
     * @param args the command line arguments
     */
    //Making main function able to throw IOException, such that I don't need to use try catch blocks.
    public static void main(String[] args) throws IOException {
        File myfile = new File ("textFile.txt");
        try{
            
            //THESE STATEMENTS NEEDS TO BE PLACED INSIDE A TRY CATCH BLOCK:
            PrintWriter myPrintWriter = new PrintWriter(myfile);
            myPrintWriter.println("This is a TEXT File!");
            System.out.println("File has been successfully created!");
            //Closing the file:
            myPrintWriter.close(); //if the file doesn't get closed the modifications made to it 
            //won't get saved.
        }
        catch(IOException e)
        {
            System.out.printf("File: %s\n", e);
        }
        //Reading from the file:
        try{
            Scanner readerfile = new Scanner(myfile);
            String Message = readerfile.nextLine();
            //If this line is reached it means that there is no exception thrown.
            System.out.printf("FILE MESSAGE: %s\n", Message);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        //Creating a collection of HumanClass objects:
        ArrayList<HumanClass> myList = new ArrayList();
        myList.add(new HumanClass(22, "Adam Lambert"));
        myList.add(new HumanClass(44, "Jackie Chan"));
        //Creating a file to store these objects:
        File myObjectsFile = new File ("objectFile.txt");
        //Serializing an object:
        try{
            FileOutputStream fo = new FileOutputStream(myObjectsFile);
            ObjectOutputStream os = new ObjectOutputStream(fo);
            for(HumanClass s:myList)
            {
                //Writing objects to a file ca be made only using binary mode. So that file will not contain
                //readable text.
                os.writeObject(s);
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.printf("File not found: %s", e);
        }
        //Deserializing an object from the file:
        ArrayList<HumanClass> ObjectRead = new ArrayList();
        FileInputStream fi = new FileInputStream(myObjectsFile);
        ObjectInputStream oi = new ObjectInputStream(fi);
        try{
            while(true) //this loop will terminate when the catch block will terminate, and the catch block will
                //terminate then EOFException will be thrown.
            {
               HumanClass e = (HumanClass) oi.readObject(); //this will read until the file ends. 
               //When it cannot read any more object from the file it will throw an EOFException that needs
              //to be catched, and handled, otherwise the program will terminate.
              ObjectRead.add(e);
            }
        }
        catch(ClassNotFoundException e)
        {
             System.out.printf("File not found: %s", e);
        }
        catch(EOFException b) //Once the file was done reading, it will catch this exception.
        {
            System.out.println("\nDone reading the objects:\n");
            //Let's print the objects now:
            for(HumanClass s:ObjectRead)
            {
                System.out.printf("Name: %s, Age: %d\n", s.GetName(), s.GetAge());
            }
        }
        //Keep the console opened until I press a key.
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
