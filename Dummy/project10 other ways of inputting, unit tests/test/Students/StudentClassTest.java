/*
 This class was created to verify the good functionality of Students.StudentClass.
To create a test class with NetBeans just open the project and then right click the main directory of it
and select New -> Other -> Unit Test -> Test for Existing Class.
UnitTest is a feature available in JAVA.

TO run the test after you completed the modifications in the TestClass just click in the NetBeans menu -> Run
-> Test File
 */
package Students;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before; 
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Black2
 */
public class StudentClassTest {
    
    public StudentClassTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of PrintStudentInfo method, of class StudentClass.
     */
    @Test
    
    //You have to modify this code to fit you class.
    public void testPrintStudentInfo() {
        System.out.println("PrintStudentInfo");
        //Modify here so instance object gets those values.
        StudentClass instance = new StudentClass ("Black", 22, 9.6);
        instance.PrintStudentInfo();
    }
    
}
