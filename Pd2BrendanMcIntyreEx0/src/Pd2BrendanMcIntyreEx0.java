/*
 Name:Brendan McIntyre
 Period:2
 Name of the Program:Ex0

 What I Learned/Reflection:
I learned the basics of exceptions and errors and how to get rid of


Question 1: What will happen when we compile this program?
unreported exception java.lang.Exception; must be caught or declared to be thrown

Question 2: How do we deal with the compile time error? Where should we
            make some changes to the program? Use the line # to tell us
            where you modify the program.
            We should use throws to throw the Exception in both the first method and the main method.

Question 3: After fixing the compile time error, what happens when
            run the syntax-free program? Any runtime error?
            There is a runtime error it is: Exception in thread "main" java.lang.Exception


Question 4: How do we get rid of the runtime error if it exists?
            Since this is unchecked, and you want to stop the run time error you can
             get rid of the throws in the main method. You should also put the first() in try
             and make a catch.

*/
public class Pd2BrendanMcIntyreEx0
{
    // Precondition: None
    // Postcondition: This method always throws an Exception and never returns normally.
    public static void first() throws Exception
    {
        throw new Exception();
    } // first

    public static void main (String [] args)
    {
        try {
            first();
        }
        catch (Exception ignored){
        }

        System.out.println ("In main and after first");
    } // main
}  // Pd2BrendanMcIntyreEx0
/********* PROGRAM OUTPUTS ******
 In main and after first

 **********************************/