/*
 This class it would do the same thing as those 2 parallel array did. It will store information regarding
the name and the grade of students.
 */
package project19;

public class Students {
    //THESE FIELDS ARE PRIVATE BY DEFAULT:
    String Name;
    int Grade;
    //CONSTRUCTOR:
    public Students(String NewName, int NewGrade)
    {
        this.Name = NewName;
        this.Grade = NewGrade;
    }
    //GETTERS:
    public int GetGrade()
    {
        return this.Grade;
    }
    public String GetName()
    {
        return this.Name;
    }
}
