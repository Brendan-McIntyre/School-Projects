/***********************************************************************
 Name:Brendan McIntyre
 Period:2
 Date:1/15/26
 What I Learned:
    I learned how to convert a number character into an integer.
 ************************************************************************/
import java.util.*;
public class Pd2BrendanMcIntyrePostfix
{
    public static void main(String[] args)
    {
        System.out.println("Enter a valid postfix expression (single digits only),");
        System.out.println("such as 35*1+");
        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.next();
        while(!s.equals("-1"))
        {
            System.out.println(s + "  --->  " + eval(s) + "\n");
            // //        System.out.println((s = "354*+7*") + " = " + eval(s) + "\n");
            // //          System.out.println((s = "82-") + " = " + eval(s) + "\n");
            // //          System.out.println((s = "82/") + " = " + eval(s) + "\n");
            s = keyboard.next();
        }
    }

    // Precondition: x is a valid postfix expression containing only
    //               single-digit integers and the operators +, -, *, /
    // Postcondition: returns the integer value of the postfix expression
    public static int eval(String x)
    {
        Stack<Integer> nums = new Stack<>();
        for(int i = 0; i < x.length(); i++){
            if(isOperator(x.charAt(i))){
                nums.push(eval(nums.pop(), nums.pop(), x.charAt(i)));
            }
            else {
                nums.push(x.charAt(i) - '0');
            }
        }
        return nums.pop();
    }

    // Precondition: ch is one of the characters '+', '-', '*', or '/'
    // Postcondition: returns the result of b (operator) a
    public static int eval(int a, int b, char ch)
    {
        if(ch == '+'){
            return b + a;
        }
        else if(ch == '-'){
            return b - a;
        }
        else if (ch == '*') {
            return b * a;
        }
        return b / a;
    }

    // Precondition: ch is any character
    // Postcondition: returns true if ch is an arithmetic operator;
    //                returns false otherwise
    public static boolean isOperator(char ch)
    {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
}