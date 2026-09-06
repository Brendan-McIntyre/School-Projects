/*****************************************************************************************************************
 NAME: Brendan McIntyre
 PERIOD: 2
 DUE DATE:12/6/26
 ASSIGNMENT: Text Editor

 PURPOSE: Getting a better understanding of how to use stacks.

 LEARNED:
 - I learned how to traverse stacks without deleting them.
 ****************************************************************************************************************/
import java.util.*;
public class Pd2BrendanMcIntyreTextEditor
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
        String again;

        System.out.println("Enter a line of text: Ca-noe$Ra3-fx-t");
        editText("Ca-noe$Ra3-fx-t");
        System.out.println("\nAgain (y/n)? y");

        System.out.println("Enter a line of text: AP$$-Compp-utee-r Sic--cei--ience");
        editText("AP$$-Compp-utee-r Sic--cei--ience");
        System.out.println("\nAgain (y/n)? y");

        System.out.println("Enter a line of text: He$He was astg-- tall ae-s a$ 6 foot,- 3 inchre-- treeu-");
        editText("He$He was astg-- tall ae-s a$ 6 foot,- 3 inchre-- treeu-");
        System.out.println("\nAgain (y/n)? y");

        System.out.println("Enter a line of text: bone matrix and pivot joint$");
        editText("bone matrix and pivot joint$");
        System.out.println("\nAgain (y/n)? y");

        System.out.println("Enter a line of text: dey$daybsah---reakk-s be-ell");
        editText("dey$daybsah---reakk-s be-ell");
        System.out.println("\nAgain (y/n)? y");

        do
        {
            System.out.print("Enter a line of text: ");
            String input = sc.nextLine();
            editText(input);
            System.out.print("\nAgain (y/n)? ");
            again = choice.next();
        }while(!again.equals("n"));
    }//main

    //pre:  s is not null
    //post: edits a String according to certain characters it contains and prints the resulted string
    public static void editText(String s)
    {
        Stack<Character> text = new Stack<Character>();
        char c;
        for(int i = 0; i < s.length();i++){
            c = s.charAt(i);
            if(c == '$'){
                while(!text.isEmpty()){
                    text.pop();
                }
            }
            else if (c == '-'){
                if(!text.isEmpty()){
                    text.pop();
                }

            }
            else{
                text.push(c);
            }
        }
        printStack(text);
    }//editText

    //pre:  none
    //post: prints the Stack in a nicer format, ex. abc instead of [a, b, c]
    public static void printStack(Stack<Character> s)
    {
        Iterator <Character> iter = s.iterator();
        System.out.print("Here is the line you entered: ");
        while(iter.hasNext()){
            System.out.print(iter.next());
        }

    }//printStack
}
/********* PROGRAM OUTPUTS ******
 Enter a line of text: Ca-noe$Ra3-fx-t
 Here is the line you entered: Raft
 Again (y/n)? y
 Enter a line of text: AP$$-Compp-utee-r Sic--cei--ience
 Here is the line you entered: Computer Science
 Again (y/n)? y
 Enter a line of text: He$He was astg-- tall ae-s a$ 6 foot,- 3 inchre-- treeu-
 Here is the line you entered:  6 foot 3 inch tree
 Again (y/n)? y
 Enter a line of text: bone matrix and pivot joint$
 Here is the line you entered:
 Again (y/n)? y
 Enter a line of text: dey$daybsah---reakk-s be-ell
 Here is the line you entered: daybreaks bell
 Again (y/n)? y
 Enter a line of text: Programing$Assign-nment-t
 Here is the line you entered: Assignment
 Again (y/n)? n

 **********************************/