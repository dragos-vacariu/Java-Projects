package project12;

import java.util.Scanner;

/*Inner Classes are the only classes that can be set to private.
THE ONLY WAY TO HAVE TO MULTIPLE CLASSES IN THE SAME .JAVA FILE IS TO USE INNER CLASSES.
*/
public class Project12 {

    public class InnerClass{
        private final String CarName; //final means const (constant);
        private final int CarSpeed;
        public InnerClass(String NameOfCar, int SpeedOfCar)
        {
            this.CarName = NameOfCar;
            this.CarSpeed = SpeedOfCar;
        }
        public void PrintInformation ()
        {
           System.out.println ("Name: " + this.CarName + " Speed: " + this.CarSpeed);
        }
        //Encapsulation (GETTERS AND SETTERS):
        public String GetCarName()
        {
            return this.CarName;
        }
    }
    public static void main(String[] args) {
        //Creating an object of outer class:
        Project12 OuterObject = new Project12();
        //Using the outer class object to create the inner class object:
        Project12.InnerClass SimpleExample = OuterObject.new InnerClass("Lamborghini", 280); //sinthax for 
        //static functions
        /*
        IF MAIN FUNCTION WAS UNSTATIC WE COULD HAVE USE THIS SINTHAX:
        Project12.InnerClass SingleClass = new Project12.InnerClass("Name", 20);
        */
        SimpleExample.PrintInformation();
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    public void DisplayInformation()
    {
        //THIS SINTHAX CAN BE USED ONLY WITH UNSTATIC FUNCTIONS:
         Project12.InnerClass SingleClass = new Project12.InnerClass("Name", 20);
    }
}
