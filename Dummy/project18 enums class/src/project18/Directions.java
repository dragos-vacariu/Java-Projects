/*
Enums can have constructors, and it needs to have contructors if they are provided with values.
 */
package project18;

public enum Directions {
    //Defining the fields:
    South(0), West(180), North(90), East(260);
    private final int Degrees; // a place to store the value for each field.
    
    //This constructor has the role of initializing the above fields with their values:
    Directions(int degreesNew)
    {
        this.Degrees = degreesNew;
    }
    public int GetDegrees()
    {
        return this.Degrees;
    }
}
/*
Enums make the code more readable, and instead of providing value and later on trying to convert values
from int to string, enums provides both string values and int values in the same patch.
*/
