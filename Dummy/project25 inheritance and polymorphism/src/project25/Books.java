/*
Inheritance means extending the functionality of a class over another. In our case the functionality of Product
get exteded over Books, because both have a price, and both have a Name;
 */
package project25;

/**
 *
 * @author Black2
 */
public class Books extends Product {
    private String Author;
    private int NrOfPages;
    public Books(String NewAuthor, int NewNrOfPages, String NewName, double NewPrice)
    {
        super(NewName, NewPrice); 
        //super refers to the parent class, so it will call the constructor of the parent class, and it will
        //initialize the two fields Price and Name.
        this.Author = NewAuthor;
        this.NrOfPages = NewNrOfPages;
    }
    //Getters:
    public String GetAuthor()
    {
        return this.Author;
    }
    public int GetNrOfPages()
    {
        return this.NrOfPages;
    }
    //Overriding the function of the parent class
    @Override
    public String GetType()
    {
        return "Book";
    }
}
