/****************************************************
 Name (Full Name): Brendan McIntyre   Period: 2
 Name of the Lab/Assignment: U2 Recursion Day 1 slide #13
 Purpose: Understanding of how to use recursion in many different ways.

 How I feel about this programming experience:
I kind of like tracing recursive methods, but making them makes me wonder in what situation is recursion
the most efficient method of solving the problem.

 What I Learned:
I learned how to use recursion in many more different ways than when we went over it last year. It also
 is helping me think of how to make things more efficient.

 ****************************************************/

public class Pd2BrendanMcIntyreU2RecursionDay1Slide13 {
    public static void main(String[] args) {
        int[] array = {3, 7, 74, 36, 25, 24, 73};

        System.out.print("1234 backwards is ");
        intBackwards(1234);
        System.out.println();

        System.out.println("Max Value: " + maxValue(array, 0));

        System.out.print("array backwards is ");
        arrayBackwards(array, 0);
        System.out.println();

        System.out.println("penguin is a Palindrome: " + checkPalindrome("penguin", 0));
        System.out.println("racecar is a Palindrome: " + checkPalindrome("racecar", 0));

        System.out.println("Sum of array: " + arraySum(array, 0));

        System.out.print("log base 2 of 16384 = " + logBaseTwo(16384, 0));
    }

    // Precondition: n >= 0
    // Postcondition: prints the digits of n in reverse order
    public static void intBackwards(int n){
        if (n < 10){
            System.out.print(n);
        }
        else {
            System.out.print(n % 10);
            intBackwards(n / 10);
        }
    }

    // Precondition: array is not null, index >= 0, array has at least 1 element
    // Postcondition: returns the maximum value in array[index..end]
    public static int maxValue(int[] array, int index){
        if(index == array.length-1){
            return array[index];
        }
        int max = maxValue(array, index + 1);
        return Math.max(array[index], max);
    }

    // Precondition: array is not null, index >= 0
    // Postcondition: prints the elements of the array in reverse order
    public static void arrayBackwards(int[] array, int index){
        if(index == array.length - 1){
            System.out.print(array[index] + ", ");
        }
        else{
            arrayBackwards(array, index + 1);
            System.out.print(array[index] + ", ");
        }
    }

    // Precondition: word is not null, index >= 0
    // Postcondition: returns true if word is a palindrome, false otherwise
    public static boolean checkPalindrome(String word, int index){
        if(index >= word.length()/2){
            return word.charAt(index) == word.charAt(word.length() - 1 - index);
        }
        return checkPalindrome(word, index + 1) &&
                word.charAt(index) == word.charAt(word.length() - 1 - index);
    }

    // Precondition: array is not null, index >= 0
    // Postcondition: returns the sum of all elements from array[index..end]
    public static int arraySum(int[] array, int index){
        if(index == array.length-1){
            return array[index];
        }
        return arraySum(array, index + 1) + array[index];
    }

    // Precondition: num > 0 and is a power of 2, exponent >= 0
    // Postcondition: returns exponent such that 2^exponent == num
    public static int logBaseTwo(int num, int exponent){
        if(Math.pow(2, exponent) == num){
            return exponent;
        }
        return logBaseTwo(num, exponent + 1);
    }
}
/********* PROGRAM OUTPUTS ******
 1234 backwards is 4321
 Max Value: 74
 array backwards is 73, 24, 25, 36, 74, 7, 3,
 penguin is a palindrome: false
 racecar is a palindrome: true
 Sum of array: 242
 log base 2 of 16384 = 14
 **********************************/