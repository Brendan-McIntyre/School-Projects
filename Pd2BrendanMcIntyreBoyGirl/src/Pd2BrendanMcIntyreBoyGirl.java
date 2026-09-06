/****************************************************
 Name: Brendan McIntyre  Period:2
 Name of the Lab/Assignment: pg 419 Exercise 1
 ****************************************************/
import java.io.*;
import java.util.*;

class Pd2BrendanMcIntyreBoyGirl {

    //Pre-condition:
    // - A file named "BoyGirl.dat" must exist in the working directory.
     // - The file must contain a sequence of strings and integers.
     // Post-condition:
     // - The BoyGirl method is called with the file contents as input.
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("BoyGirl.dat"));
        BoyGirl(input);
    }

    // Pre-condition:
    // - The input Scanner must contain a sequence of strings and integers.
    // - Integers must be in alternating boy-girl order (boy name, boy score, girl name, girl score, etc.)
    // Post-condition:
    // - Prints the total sum of boy scores and girl scores.
    // - Prints the absolute difference between the sums of boy and girl scores.
    public static void BoyGirl(Scanner input){
        int boy = 0;
        int girl = 0;
        int counter = 0;

        while (input.hasNextInt()) {
            if (counter % 2 == 0) {
                boy += input.nextInt();
            } else {
                girl += input.nextInt();
            }
            counter++;
        }

        System.out.println(boy + " boys, " + girl + " girls");
        System.out.print("Difference between boys' and girls' sums: " + Math.abs(boy - girl));
    }
}
