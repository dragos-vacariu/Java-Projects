package Args_main;

//Working with command prompts arguments.

//IMPORTING PACKAGE:
import java.util.Scanner;

public class Args_main{
    public static void main(String[] args) { //args will store the command prompt arguments -- if any
        //Supposingly we have some arguments in args[]
        
        int [] lenNrs = Args_main.NumberOrNo(args); //convert them to numbers or get their string length
        Sorting(lenNrs, args); //sort the numbers of lenghts
        
        System.out.printf("Sorting by length or value: \n\n");
        for (int i=0; i<args.length; i++)
        {
            System.out.printf("%d <--> %s\n", lenNrs[i], args[i]); //print results
        }
        Scanner myscanner = new Scanner(System.in);
        myscanner.next();
        //cursor to the next line.
        
    }
    public static int[] NumberOrNo(String[] arguments) //we shall return an array
    {
        int[] someArray = new int[arguments.length]; //lets build an array of the same length as arguments array
        for (int i=0; i<arguments.length; i++)
        {
            try{
                someArray[i] = Integer.parseInt(arguments[i]); //try to convert to int
            }
            catch (Exception e){
                someArray[i] = arguments[i].length(); // if not succesfull then we are having a letter string / word
                //take out it's length
            }
        }
        return someArray;
    }
    
    public static void Sorting (int[] nrsOrNo, String[] arguments) //no need to return anything, lists/arrays are always passed by reference
    {
        //DO the sorting thing
        for (int i=0; i < nrsOrNo.length; i++)
        {
            for (int j=0; j<nrsOrNo.length; j++ )
                if (nrsOrNo[j] < nrsOrNo[i])
                {
                    int temp = nrsOrNo[i];
                    nrsOrNo[i] = nrsOrNo[j];
                    nrsOrNo[j] = temp;
                    String argTmp = arguments[i];
                    arguments[i] = arguments [j];
                    arguments [j] = argTmp;
                }
        }
    }
}
