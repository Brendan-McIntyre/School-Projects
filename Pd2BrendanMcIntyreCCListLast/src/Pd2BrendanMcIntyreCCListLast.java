import java.util.List;
/*********************************************************************
 * Name:Brendan McIntyre
 * Period:2
 * Name of the Lab:CCListLast
 * Purpose of the Program: To make changes to
 * Due Date:11/24/25
 * Date Submitted:11/24/25
 * What I learned:
 * 1. That when you to lists that are circular but not double it is easier when the pointer is
 * the last node.
 * How I feel about this lab:
 * This lab was like the previous one but a little easier since there were more methods.
 *********************************************************************/

public class Pd2BrendanMcIntyreCCListLast <E>
{
    private ListNode <E> lastNode;  // pointer pointing at the LAST node of the list
    // not the first node!

    // addFirst: adds a node at the beginning
    // Precondition: v is the value to add (can be any object of type E).
    // Postcondition: A new node containing v is added at the start of the list.
    public void addFirst(E v) {
        if (lastNode == null) {
            lastNode = new ListNode<>(v, null);
            lastNode.setNext(lastNode);
        } else {
            ListNode<E> newNode = new ListNode<>(v, lastNode.getNext());
            lastNode.setNext(newNode);
        }
    }

    // addLast: adds a node at the end
    // Precondition: v is the value to add (can be any object of type E).
    // Postcondition: A new node containing v is added at the end of the list.
    public void addLast(E v) {
        addFirst(v);
        lastNode = lastNode.getNext();
    }

    // size: returns the number of nodes
    // Precondition: None (works on an empty or non-empty list).
    // Postcondition: Returns the total number of nodes in the list.
    public int size() {
        if (lastNode == null) return 0;

        int count = 1;
        ListNode<E> current = lastNode.getNext();
        while (current != lastNode) {
            current = current.getNext();
            count++;
        }
        return count;
    }

    // removeFirst: removes and returns the first node
    // Precondition: The list may be empty or non-empty.
    // Postcondition: Removes the first node and returns its value; returns null if the list is empty.
    public E removeFirst() {
        if (lastNode == null) return null;

        ListNode<E> first = lastNode.getNext();
        E value = first.getValue();

        if (first == lastNode) {
            lastNode = null;
        } else {
            lastNode.setNext(first.getNext());
        }
        return value;
    }

    // removeLast: removes and returns the last node
    // Precondition: The list may be empty or non-empty.
    // Postcondition: Removes the last node and returns its value; returns null if the list is empty.
    public E removeLast() {
        if (lastNode == null) return null;

        ListNode<E> first = lastNode.getNext();
        E value = lastNode.getValue();

        if (lastNode == first) {
            lastNode = null;
        } else {
            // find node before lastNode
            ListNode<E> current = first;
            while (current.getNext() != lastNode) {
                current = current.getNext();
            }
            current.setNext(first);
            lastNode = current;
        }

        return value;
    }

    // toString: returns string representation of list
    // Precondition: None (works on an empty or non-empty list).
    // Postcondition: Returns the string representation of the list in the format [a, b, c]; "[]" if empty.
    public String toString() {
        if (lastNode == null) {
            return "[]";
        }

        String print = "[";
        ListNode<E> current = lastNode.getNext();
        print += current.getValue();

        current = current.getNext();
        while (current != lastNode.getNext()) {
            print += ", " + current.getValue();
            current = current.getNext();
        }

        print += "]";
        return print;
    }

    public static void main(String args[])
    {
        Pd2BrendanMcIntyreCCListLast <Integer> myList = new Pd2BrendanMcIntyreCCListLast <Integer> ();

        myList.addFirst(9);
        myList.addFirst(10);
        myList.addFirst(11);
        myList.addFirst(1);
        myList.addLast(99);
        System.out.println("The CCList: \n" + myList);
        myList.removeLast();

        System.out.println("The CCList: \n" + myList);
        System.out.println("List Size: " + myList.size());

    } // main

} // CCList

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
/********* PROGRAM OUTPUTS ******
 The CCList:
 [1, 11, 10, 9, 99]
 The CCList:
 [1, 11, 10, 9]
 List Size: 4
 **********************************/