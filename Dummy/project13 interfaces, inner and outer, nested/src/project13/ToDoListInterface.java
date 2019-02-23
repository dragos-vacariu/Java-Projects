/*
Just like classes, there can be only one interface in a .JAVA file. Java does not allow that interfaces and
classes to be defined in the same file.
There can be inner interfaces also, this is the only way to write 2 interfaces in the same .JAVA file.

MORE DOCUMENTATION IN THE MAIN FILE:
 */
package project13;

/**
 *
 * @author Black2
 */
public interface ToDoListInterface { //this is the outer interface
    public interface Numbers{ //this is the inner interface
        int findMax(int a, int b, int c);
    }
    void PrintMessage(String message);
}
