import java.util.*;

public class ConcurrentModificationDemo
{
    public static void main (String [] args)
    {
        ArrayList <Integer> c = new ArrayList <>();

        c.add (1);
        c.add (2);
        c.add (3);

        ListIterator <Integer> itr = c.listIterator();
        ListIterator <Integer> reverse = c.listIterator(c.size());
        int i = 0;

        // Traversing the list
        while (itr.hasNext() && reverse.hasPrevious())
        {
            System.out.println ("\nUsing the iterator: " + itr.next() );
            System.out.println ("Using the list reference: " + c.get (i++));
        }
        reverse.previous();
        reverse.remove();

        // Append '9' to the end of the list
        c.add (9);
        System.out.println ("\nAfter appending '9' to the list, the list becomes: " + c);   // [1, 2, 3, 9]

    } // main
} // ConcurrentModificationDemo

/******************************************************************  Outputs

 ----jGRASP exec: java ConcurrentModificationDemo

 Using the iterator: 1
 Using the list reference: 1

 Using the iterator: 2
 Using the list reference: 2

 Using the iterator: 3
 Using the list reference: 3

 After appending '9' to the list, the list becomes: [1, 2, 3, 9]

 ----jGRASP: operation complete.

 **************************************************************************/