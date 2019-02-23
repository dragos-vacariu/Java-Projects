/*
Creating a comparator:
Any class can override a function. If a class inherits a method from its superclass, then there is a chance 
to override the method provided that it is not marked final.

The benefit of overriding is: ability to define a behavior that's specific to the subclass type, which 
means a subclass can implement a parent class method based on its requirement.

In object-oriented terms, overriding means to override the functionality of an existing method.
*/
package project21;

import java.util.Comparator;

/**
 *
 * @author Black2
 */
public class IntegerComparator implements Comparator<Integer>{
    
    @Override //telling the compiler to replace the existent compare function that this Comparator class has
    //with this particular function compare.
    //I need to have this function in order to can access the predefined Sorting function that collection class
    //has. This function  needs to return 0 if A==B, to return 1 if B<A, or to return -1 if A<B, because these
   //are the requirements for the sorting and searching functions to work.
    public int compare(Integer A, Integer B)
    {
        return A-B; //this should achieve our goal.
    }
    
}
