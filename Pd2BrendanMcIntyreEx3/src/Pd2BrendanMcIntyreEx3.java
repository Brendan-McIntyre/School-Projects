/**
 Question 1: Compile the program and report any compile-time error you found.
 Question 2: Is ArithmeticException a runtime exception or compile-time exception?
    Runtime exception
 Question 3: If we want to deal with the exception in method third, what should we do?
    Make try catch blocks to stop the runtime error from happening with the throw in the try block.
 Question 4: If we want to deal with the exception in method second, what should we do?
    It is already dealt with in third().
 Question 5: If we want to deal with the exception in method first, what should we do?
    It is already dealt with in third().
 Question 6: If we want to deal with the exception in method main, what should we do?
    It is already dealt with in third().
 */

public class Pd2BrendanMcIntyreEx3
{
    public static void first()
    {
        second();

    } // first

    public static void second()
    {
        third();
    } // second

    public static void third()
    {
        try {
            throw new ArithmeticException("Oh, no!");
        }
        catch(ArithmeticException ignored){

        }
    } // third

    public static void main (String [] args)
    {
        first();
        System.out.println ("In main and after first");
    }
}  //

