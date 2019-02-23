/*
Polymorphism is the ability of an object to take on many forms. The most common use of polymorphism in 
OOP occurs when a parent class reference is used to refer to a child class object.
 */
package project25;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Black2
 */
public class Project25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Product myProduct = new Product("Watch", 30.2);
        Books myBook = new Books("Garbriel Garcia", 223, "Adventurous Morning", 22.3);
        System.out.printf("Type: %s\t Name: %s\t Price: %f\n\n", myProduct.GetType(), myProduct.GetName(),
                myProduct.GetPrice());
        System.out.printf("Type: %s\t Name: %s\t Price: %f\n\tAuthor: %s\t\t NPages: %d\n", myBook.GetType(),
                myBook.GetName(), myBook.GetPrice(), myBook.GetAuthor(), myBook.GetNrOfPages());
        //Polymorphism:
        System.out.println("\n\nPolymorphism:\n");
        ArrayList <Product> myList = new ArrayList();
        //adding objects of type book to an arrayList of type Product, and it works because Books inherits from
        //Product.
        myList.add(myProduct);
        myList.add(myBook);
        for(Product k : myList)
        {
            System.out.printf("Type: %s\n", k.GetType());
        }
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
