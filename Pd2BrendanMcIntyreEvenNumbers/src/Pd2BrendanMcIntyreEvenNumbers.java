/****************************************************
 Name: Brendan McIntyre  Period:2
 Name of the Lab/Assignment: pg 419 Exercise 2
 ****************************************************/

import java.io.*;
import java.util.*;

public class Pd2BrendanMcIntyreEvenNumbers {


     // Pre-condition:
     // - A file named "numbers.dat" must exist in the working directory.
     // - The file must contain a sequence of integers.

     // Post-condition:
     // - The EvenNumbers method is called with the contents of the file.
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("numbers.dat"));
        EvenNumbers(input);
    }

     // Pre-condition:
     // - The Scanner must be positioned at the beginning of a stream of integers.

     // Post-condition:
     // - Prints the total number of integers.
     // - Prints the sum of all integers.
     // - Prints the number of even integers.
     // - Prints the percentage of even numbers with respect to the total count.
    public static void EvenNumbers(Scanner input) {
        int evens = 0;
        int nums = 0;
        int sum = 0;

        while (input.hasNextInt()) {
            int current = input.nextInt();
            if (current % 2 == 0) {
                evens++;
            }
            sum += current;
            nums++;
        }

        System.out.println(nums + ", sum = " + sum);
        System.out.println(evens + " evens (" + ((nums > 0 ? ((double) evens / nums * 100) : 0.0)) + "%)");
    }
}
