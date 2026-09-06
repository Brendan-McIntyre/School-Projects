/****************************************************
 Name (Full Name): Brendan McIntyre   Period: 2
 Name of the Lab/Assignment: ListExploration worksheet
 Purpose: To foster understanding of how to use ListNodes and be able to access and modify all the
 information in them.

 How I feel about this programming experience:
I think these methods were very helpful in me better understanding ListNodes because
 they asked to both access and change both sides of a ListNode.

 What I Learned:
 The first thing I realize when my code wasn't working in the beginning was that you need a class for
 ListNodes. After that, I was able to learn how to change ListNodes and a learned a little more on how to Access parts of
 a ListNode

 ****************************************************/

import java.util.List;
import java.util.Scanner;

public class Pd2BrendanMcIntyreListExploration {
    public static void main(String[] args) {
        ListNode <String> head = new ListNode <> ("hello", null);
        head = new ListNode <> ("foo", head);
        head = new ListNode <> ("boo", head);
        head = new ListNode <> ("nonsense", head);
        head = new ListNode <> ("computer",
                new ListNode <> ("science",
                new ListNode <> ("java",
                new ListNode <> ("coffee", head))));

        Scanner scan = new Scanner(System.in);

        print(head);
        System.out.println("First = " + first(head));
        System.out.println("Second = " + second(head));
        System.out.println("Pointer to Last = " + first(pointerLast(head)) + " at " + pointerLast(head));
        System.out.println("Copy of Last = " + first(copyOfLast(head)) + " at " + copyOfLast(head));
        System.out.print("Insert " );
        String input1 = scan.next();
        String input2 = scan.next();
        print(insertLast(insertFirst(head, input1), input2));

    }
    // Precondition: arg may be null
    // Postcondition: returns a new ListNode with the same value as arg, next = null; returns null if arg is null
    public static ListNode<String> copyNode(ListNode<String> arg){
        if(arg == null){
            return null;
        }
        ListNode<String> copy = new ListNode<String>(arg.getValue(), null);
        return copy;
    }

    // Precondition: arg may be null
    // Postcondition: returns a deep copy of the entire list starting at arg; returns null if arg is null
    public static ListNode<String> copyList(ListNode<String> arg){
        if(arg == null){
            return null;
        }
        ListNode<String> copy = new ListNode(arg.getValue(), null);
        copy.setNext(copyList(arg.getNext()));
        return copy;
    }

    // Precondition: arg != null and arg.getNext() != null
    // Postcondition: returns a deep copy of the list starting from the second node
    public static ListNode<String> rest(ListNode<String> arg){
        if(arg == null){
            return null;
        }
        ListNode<String> copy = new ListNode(arg.getNext().getValue(), null);
        copy.setNext(copyList(arg.getNext().getNext()));
        return copy;
    }

    // Precondition: head may be null
    // Postcondition: prints the list in [elem1, elem2, ...] format
    public static void print(ListNode<String> head){
        System.out.print("[");
        while(head != null){
            System.out.print(head.getValue());
            head = head.getNext();
            if(head != null)
                System.out.print(", ");
        }
        System.out.println("]");
    }

    // Precondition: head != null
    // Postcondition: returns the value of the first node in the list
    public static String first(ListNode<String> head){
        return head.getValue();
    }

    // Precondition: head != null and head.getNext() != null
    // Postcondition: returns the value of the second node in the list
    public static String second(ListNode<String> head){
        return rest(head).getValue();
    }

    // Precondition: head != null
    // Postcondition: returns a reference to the last node in the list
    public static ListNode<String> pointerLast(ListNode<String> head){
        if(head.getNext() == null || head == null){
            return head;
        }
        return pointerLast(head.getNext());
    }

    // Precondition: head != null
    // Postcondition: returns a new ListNode copy of the last node in the list
    public static ListNode<String> copyOfLast(ListNode<String> head){
        return copyNode(pointerLast(head));
    }

    // Precondition: head may be null; arg != null
    // Postcondition: returns a new list with arg inserted at the front
    public static ListNode<String> insertFirst(ListNode<String> head, String arg){
        return new ListNode<String>(arg, head);
    }

    // Precondition: head != null; arg != null
    // Postcondition: returns a new list with arg inserted at the end; original list is unchanged
    public static ListNode<String> insertLast(ListNode<String> head, String arg){
        if(head.getNext() == null){
            return new ListNode<>(arg, null);
        }
        ListNode<String> last = insertLast(head.getNext(), arg);
        last = new ListNode<>(head.getValue(), last);
        return last;
    }


}
class ListNode <E>
{
    private E value;
    private ListNode <E> next;

    public ListNode(E initValue, ListNode <E> initNext)
    {
        value = initValue;
        next = initNext;
    }
    public E getValue()
    {
        return value;
    }
    public ListNode <E> getNext()
    {
        return next;
    }
    public void setValue(E theNewValue)
    {
        value = theNewValue;
    }
    public void setNext(ListNode <E> theNewNext)
    {
        next = theNewNext;
    }
}
/********* PROGRAM OUTPUTS ******
 [computer, science, java, coffee, nonsense, boo, foo, hello]
 First = computer
 Second = science
 Pointer to Last = hello at ListNode@d2cc05a
 Copy of Last = hello at ListNode@4f933fd1
 Insert what? what?
 [what?, computer, science, java, coffee, nonsense, boo, foo, what?]
 **********************************/