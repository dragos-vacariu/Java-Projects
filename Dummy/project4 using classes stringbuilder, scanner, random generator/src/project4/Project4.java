package project4;
//Importing the packages:
import java.util.Random;
import java.util.Scanner;

public class Project4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Creating a random number generator
        Random randNum = new Random(); //this will create a random generated seeded by TIME;
        int a = randNum.nextInt(10); // this will generate a random value between 1 and 9;
        System.out.printf("The random number: %d\n", a);
        StringBuilder strBuilder = new StringBuilder();
        strBuilder = strBuilder.append("This is a simple message!");
        System.out.printf("The normal: %s\n", strBuilder);
        strBuilder = strBuilder.reverse();
        System.out.printf("The reverse: %s\n", strBuilder);
        strBuilder = strBuilder.replace(1, strBuilder.capacity(), " My name is written here !");
        System.out.printf("%s\n", strBuilder);
        a = strBuilder.indexOf("name", 0);
        System.out.printf("'Name' starts on position %d\n", a);
        strBuilder.deleteCharAt(0); // delete the character at position 0;
        strBuilder.deleteCharAt(0); // delete de new character at position 0;
        System.out.printf("%s\n", strBuilder);
        strBuilder.setLength(10); // resize the StringBuilder, will delete everything after
        //index 10.
        System.out.printf("%s\n", strBuilder);
        System.out.printf("Press any key to terminate!\n");
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
    }
    
}
