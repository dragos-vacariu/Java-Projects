/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project21;

import java.util.Comparator;

/**
 *
 * @author Black2
 */
public class StudentNameComparator implements Comparator<StudentNames>{
    @Override
    public int compare(StudentNames S1, StudentNames S2)
    {
        return S1.GetName().compareToIgnoreCase(S2.GetName());
        //This function will compare the two string values return by S1.GetName() and S2.GetName(), which
        //will contain the name of the students, and CompareToIgnoreCase will do the work for us, it will
        //return 1 is S1>S2, 0 if they are equal or -1 if S2>S1, because this is the way that the function
        //was designed.
    }
}
