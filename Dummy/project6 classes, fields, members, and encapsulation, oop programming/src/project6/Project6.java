package project6;

/**
 *
 * @author Black2
 */
public class Project6 {
    public static void main(String[] args) {
        int a = 2; 
        int b = ~a; // this operator has the effect of fliping the bits:
        //EXAMPLE: 0010 becomes 1101, all the 1 bits become 0 and all the 0 bits become 1.
        //SO FROM a = 2 (0000 0010) BY APPLYING b= ~a WILL RESULT b= (1111 1111) which is -3
        /*so it will keep the 1 bits unchanged and it will change the 0 bits to 1.*/
        System.out.printf("%d\n", b);
        DiceClass myDice = new DiceClass(4, 11);
        myDice.PrintTheDieValue();
    }
    
}
