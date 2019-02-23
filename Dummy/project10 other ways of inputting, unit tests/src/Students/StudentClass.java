/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Students;

/**
 *
 * @author Black2
 */
public class StudentClass {
    private final String StudentName; // final is equivalent to const from c, c++, c#. A final variable
    //has constant value.
    private final int StudentAge;
    private final double StudentGrade;
    public StudentClass(String Name, int Age, double Grade)
    {
        //this keyword it's used to refer exactly to a field/member of this class. This avoids ambiguity
        //when 2 variables has the same name, so the compiler doesn't know which one you refering to.
        this.StudentAge = Age;
        this.StudentGrade = Grade;
        this.StudentName = Name;
    }
    public void PrintStudentInfo()
    {
        System.out.println("Student: " + this.StudentName + "    Age: " + this.StudentAge +
                "   Grade: "+ this.StudentGrade);
    }
}
