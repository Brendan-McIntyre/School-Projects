/*********************************************************************************
 NAME: Brendan McIntyre
 PERIOD: 2
 DATE SUBMITTED:11/11/25
 DUE DATE: 11/12/25
 ASSIGNMENT: U4: List Exploration Program

 PURPOSE OF THE LAB:
 The purpose is to explore ListNodes in more unique ways.

 NEW CONCEPTS LEARNED:
 -To delete something you just have to make something new and not include it.
 -To reverse something

 HOW I FEEL ABOUT THIS LAB:
 -It was fairly simple since it was just the previous assignment with adding two more methods
 */
import java.util.*;
public class Pd2BrendanMcIntyreListExplorationExtention
{
    public static void main(String[] args)
    {
        ListNode <String> head = new ListNode <>("hello", null);

        head = new ListNode <>("foo", head);
        head = new ListNode <>("boo", head);
        head = new ListNode <>("nonsense", head);
        head = new ListNode <>("computer",
                new ListNode <>("science",
                        new ListNode <>("java",
                                new ListNode <>("coffee", head))));

        print(head);

        System.out.println("First = " + first(head));
        System.out.println("Second = " + second(head));
        ListNode  <String> p = pointerToLast(head);
        System.out.println("Pointer to Last = " + p.getValue()+ " at " + p);

        ListNode  <String> c = copyOfLast(head);
        System.out.println("Copy of Last =    " + c.getValue()+ " at " + c);

        Scanner in = new Scanner(System.in);
        System.out.print("Insert what? ");
        String x = in.next();
        head = insertFirst(head, x);
        head = insertLast(head, x);
        print(head);
        print(delete(head, 2));
        print(reverse(head));
    }
    // Precondition: head may be null
    // Postcondition: prints all elements in the list in order, enclosed in square brackets;
    // prints an empty list as []
    public static void print(ListNode<String> head)
    {
        System.out.print("[");
        while(head != null)
        {
            System.out.print(head.getValue());
            head = head.getNext();
            if(head != null)
                System.out.print(", ");
        }
        System.out.println("]");
    }//print

    // Precondition: arg may be null
    // Postcondition: returns a new ListNode with the same value and next reference as arg; returns null if arg is null
    public static ListNode<String> copyNode(ListNode<String> arg){
        if(arg == null){
            return null;
        }
        return new ListNode<String>(arg.getValue(), arg.getNext());
    }

    // Precondition: arg may be null
    // Postcondition: returns a deep copy of the entire list starting at arg; returns null if arg is null
    public static ListNode<String> copyList(ListNode<String> arg){
        if(arg == null){
            return null;
        }
        return new ListNode(arg.getValue(), copyList(arg.getNext()));
    }

    // Precondition: arg != null
    // Postcondition: returns a deep copy of the list excluding the first node
    public static ListNode<String> rest(ListNode<String> arg){
        if(arg == null){
            return null;
        }
        return copyList(arg.getNext());
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
    public static ListNode<String> pointerToLast(ListNode<String> head){
        if(head.getNext() == null || head == null){
            return head;
        }
        return pointerToLast(head.getNext());
    }

    // Precondition: head != null
    // Postcondition: returns a new ListNode that is a copy of the last node in the list
    public static ListNode<String> copyOfLast(ListNode<String> head){
        return copyNode(pointerToLast(head));
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

    // Precondition: head != null and position >= 0
    // Postcondition: returns a new list with the node at the specified position removed; original list is unchanged
    public static <E> ListNode<E> delete(ListNode<E> head, int position) {
        if (head == null) {
            return null;
        }

        if (position == 0) {
            return head.getNext();
        }

        head.setNext(delete(head.getNext(), position - 1));
        return head;
    }

    // Precondition: head may be null
    // Postcondition: returns a new list with the elements of head reversed
    public static ListNode<String> reverse(ListNode<String> head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

        ListNode<String> reversed = reverse(head.getNext());
        print(reversed);
        head.getNext().setNext(head);
        head.setNext(null);

        return reversed;
    }
} // Pd2BrendanMcIntyreListExplorationExtention


class ListNode <E>
{
    private E value;
    private ListNode <E>  next;

    public ListNode  (E  initValue, ListNode <E> initNext)
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

    public void setNext(ListNode  <E> theNewNext)
    {
        next = theNewNext;
    }
}  // end of ListNode