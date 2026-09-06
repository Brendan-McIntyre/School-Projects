/***********************************************************************
 Name:Brendan McIntyre
 Period:2
 Date:1/21/26
 What I Learned: I learned how to sort things using stacks.
 ************************************************************************/
import java.util.*;
public class Pd2BrendanMcIntyreParenMatch
{
    public static final String left  = "([{<";
    public static final String right = ")]}>";
    public static void main(String[] args)
    {
        Stack<String> equations = new Stack<>();
        equations.push("5+7");
        equations.push("(5+7)");
        equations.push(")5+7(");
        equations.push("((5+7)*3)");
        equations.push("[(5+7)*]3");
        equations.push("<{5+7}*3>");
        equations.push("(5+7)*3");
        equations.push("5+(7*3)");
        equations.push("((5+7)*3");
        equations.push("[(5+7]*3) ");
        equations.push("[(5+7)*3])");
        equations.push("([(5+7)*3]");

        while(!equations.isEmpty()){
            String equation = equations.peek();
            if(check(equations.pop()))
                System.out.println(equation + " is good.");
            else
                System.out.println("No, no, no.  Bad.  " + equation);
        }

        System.out.println("Enter an expression with grouping symbols,");
        System.out.println("such as (2+3)-[5*(6+1)]IndexMals");
        Scanner keyboard = new Scanner(System.in);
        String s = keyboard.next();

        while(!s.equals("-1"))
        {
            boolean flag = check(s);
            if(flag)
                System.out.println(s + " is good.");
            else
                System.out.println("No, no, no.  Bad.  " + s);
            System.out.println();
            s = keyboard.next();
        }
    }
    // precondition: s is a non-null String containing any characters
    // postcondition: returns true if all grouping symbols in s are
    //     properly matched and nested; otherwise returns false
    public static boolean check(String s){
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (left.indexOf(ch) != -1){
                stack.push(ch);
            }

            else if (right.indexOf(ch) != -1){
                if (stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();

                if (left.indexOf(top) != right.indexOf(ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
// Program outputs should include all the test cases described in the lab specifications