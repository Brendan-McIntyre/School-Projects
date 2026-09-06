/****************************************************
 Name (Full Name): Brendan McIntyre   Period: 2
 Name of the Lab/Assignment: Unit 2 Worksheet 3
 Purpose: Making recursive methods in new ways

 How I feel about this programming experience:
I think this was one of the easier than the other ones that have been assigned.

 What I Learned:
 There are many ways to do a recursive method especially when you involve helper methods. 

 ****************************************************/

public class Pd2BrendanMcIntyreU2Worksheet3 {
    public static void main(String[] args) {
        System.out.println("3 * 4 = " + multiply(3, 4));
        System.out.println("8 * 7 = " + multiply(8, 7));

        System.out.println("cat is running reversed: " + reverseString("cat is running"));
        System.out.println("the duck is flying reversed is " + reverseString("the duck is flying reversed"));

        System.out.println("Waffles contains e, l, and f. " + elfish("waffles"));
        System.out.println("Lobster contains e, l, and f. " + elfish("lobster"));

        System.out.println("The word anteater contains arena. " + (xlsh("arena", "anteater")));
        System.out.print("The word pepper contains peter. " + xlsh("peter", "pepper"));
    }

    // Precondition: b >= 1
    // Postcondition: returns the product of a and b using recursion
    public static int multiply(int a, int b) {
        if (b == 1) {
            return a;
        }
        return multiply(a, b - 1) + a;
    }

    // Precondition: words is a non-null String that may contain spaces
    // Postcondition: returns a new String with the order of words reversed
    public static String reverseString(String words) {
        if (words.indexOf(" ") < 0) {
            return words;
        }
        return reverseString(words.substring(words.indexOf(" ") + 1)) + " " + words.substring(0, words.indexOf(" "));
    }

    // Precondition: word is a non-null String
    // Postcondition: returns true if word contains all letters 'e', 'l', and 'f'; false otherwise
    public static Boolean elfish(String word) {
        return elfishHelper(word, false, false, false);
    }

    // Precondition: word is a non-null String; e, l, and f are Boolean flags tracking found letters
    // Postcondition: returns true if all three letters 'e', 'l', and 'f' have been found in word; false otherwise
    public static Boolean elfishHelper(String word, Boolean e, Boolean l, Boolean f) {
        if (e && l && f == true) {
            return true;
        }
        if (word.length() == 0) {
            return false;
        }
        char letter = word.charAt(0);
        if (letter == 'e') {
            e = true;
        } else if (letter == 'l') {
            l = true;
        } else if (letter == 'f') {
            f = true;
        }
        return elfishHelper(word.substring(1, word.length()), e, l, f);
    }

    // Precondition: word1 and word2 are non-null Strings
    // Postcondition: returns true if every character in word1 appears in word2 (order doesn’t matter)
    public static Boolean xlsh(String word1, String word2) {
        if (word1.length() == 0) {
            return true;
        }
        if (word2.indexOf(word1.charAt(0)) < 0) {
            return false;
        }
        return xlsh(word1.substring(1), word2);
    }

}
/********* PROGRAM OUTPUTS ******
 3 * 4 = 12
 8 * 7 = 56
 cat is running reversed: running is cat
 the duck is flying reversed is reversed flying is duck the
 Waffles contains e, l, and f. true
 Lobster contains e, l, and f. false
 The word anteater contains arena. true
 The word pepper contains peter. false
 **********************************/