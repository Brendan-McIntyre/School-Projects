/***********************************************************************************************************************************************
 * Name:Brendan McIntyre
 * Period:2
 * Name of the Lab: DCLL
 * Purpose of the Program:
 * Due Date: 11/24/25
 * Date Submitted:11/23/25
 * What I learned:
 * 1.Using doubly circular link lists make some things easier, but they can also make some things
 * slightly more challenging.
 * How I feel about this lab: This lab was kind of difficult to start, but I was able to understand it.
 *************************************************************************************************************************************************/
public class Pd2BrendanMcIntyreDCLL <E>   // Doubly, circular Linked List with a dummy header node
{
    private int size;
    private DCLNode <E> head = new DCLNode <> (); //dummy node--very useful--simplifies the code

    // Precondition: none
    // Postcondition: returns the number of elements in the list
    public int size()
    {
        return size;
    }

    // Precondition: obj is not null (optional, depends on list policy)
    // Postcondition: obj is added to the end of the list; size increased by 1; returns true
    public boolean add(E obj)
    {
        if (head == null) {
            head = new DCLNode<>();
            head.setNext(head);
            head.setPrev(head);
        }
        DCLNode<E> newNode = new DCLNode<>(obj, head.getPrev(), head);
        head.getPrev().setNext(newNode);
        head.setPrev(newNode);
        size++;
        return true;
    }

    // Precondition: index >= 0 && index <= size; obj is not null (optional)
    // Postcondition: obj inserted at position index; all elements after index are shifted; size increased by 1
    public void add(int index, E obj)
    {
        if (head == null) {
            head = new DCLNode<>();
            head.setNext(head);
            head.setPrev(head);
        }

        DCLNode<E> current = head.getNext();
        int i = 0;
        while (current != head && i < index) {
            current = current.getNext();
            i++;
        }

        DCLNode<E> newNode = new DCLNode<>(obj, current.getPrev(), current);
        current.getPrev().setNext(newNode);
        current.setPrev(newNode);
        size++;
    }

    // Precondition: index >= 0 && index < size
    // Postcondition: returns the element at position index, or null if index invalid
    public E get(int index)
    {
        if (index < 0 || index >= size) return null;

        DCLNode<E> current = head.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    // Precondition: index >= 0 && index < size
    // Postcondition: replaces element at index with obj; size unchanged
    public void set(int index, E obj)
    {
        if (index < 0 || index >= size) return;

        DCLNode<E> current = head.getNext();
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setValue(obj);
    }

    // Precondition: index >= 0 && index < size; list not empty
    // Postcondition: removes node at index; size decreased by 1; returns removed element or null if invalid
    public E remove(int index)
    {
        if (head == null || head.getNext() == null || index < 0 || index >= size) {
            return null;
        }

        DCLNode<E> current = head.getNext();
        int i = 0;
        while (current != head && i < index) {
            current = current.getNext();
            i++;
        }

        E removedValue = current.getValue();
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return removedValue;
    }

    // Precondition: obj is not null
    // Postcondition: obj added at beginning of list; size increased by 1
    public void addFirst(E obj)
    {
        if (head == null) {
            head = new DCLNode<>();
            head.setNext(head);
            head.setPrev(head);
        }
        DCLNode<E> newNode = new DCLNode<>(obj, head, head.getNext());
        head.getNext().setPrev(newNode);
        head.setNext(newNode);
        size++;
    }

    // Precondition: obj is not null
    // Postcondition: obj added at end of list; size increased by 1
    public void addLast(E obj)
    {
        if (head == null) {
            head = new DCLNode<>();
            head.setNext(head);
            head.setPrev(head);
        }
        DCLNode<E> newNode = new DCLNode<>(obj, head.getPrev(), head);
        head.getPrev().setNext(newNode);
        head.setPrev(newNode);
        size++;
    }

    // Precondition: list not empty
    // Postcondition: returns first element; null if list empty
    public E getFirst()
    {
        if (size == 0){
            return null;
        }
        return head.getNext().getValue();
    }

    // Precondition: list not empty
    // Postcondition: returns last element; null if list empty
    public E getLast()
    {
        if(size == 0){
            return null;
        }
        return head.getPrev().getValue();
    }

    // Precondition: list not empty
    // Postcondition: first element removed; size decreased by 1; returns removed element; null if empty
    public E removeFirst()
    {
        if (size == 0){
            return null;
        }
        DCLNode<E> first = head.getNext();
        E val = first.getValue();
        head.setNext(first.getNext());
        first.getNext().setPrev(head);
        size--;
        return val;
    }

    // Precondition: list not empty
    // Postcondition: last element removed; size decreased by 1; returns removed element; null if empty
    public E removeLast()
    {
        if (size == 0){
            return null;
        }
        DCLNode<E> last = head.getPrev();
        E val = last.getValue();
        last.getPrev().setNext(head);
        head.setPrev(last.getPrev());
        size--;
        return val;
    }

    public String toString()
    {
        if (head == null || head.getNext() == head) { // empty list
            return "[]";
        }

        String print = "[";
        DCLNode<E> current = head.getNext(); // first real node

        while (current != head) {
            print += current.getValue();

            current = current.getNext();
            if (current != head) { // add comma if not at the end
                print += ", ";
            }
        }

        print += "]";
        return print;
    }



    public static void main(String args[])
    {
        Pd2BrendanMcIntyreDCLL <String> list = new Pd2BrendanMcIntyreDCLL <> ();

        list.addLast("Apple");
        list.addLast("Banana");
        list.addLast("Cucumber");
        list.add("Dumpling");
        list.add("Escargot");
        System.out.println(list);
        System.out.println("Size: " + list.size());
        Object obj = list.remove(3);
        System.out.println(list);
        System.out.println("Size: " +list.size());
        System.out.println("Removed "+ obj);
        System.out.print("Add at 3:   ");
        list.add(3,"Cheese");
        System.out.println(list);
        System.out.println("Get values at 1 and first: " + list.get(1)+" and " + list.getFirst());
        System.out.println("No change: " +list);
        System.out.println( list.removeFirst() + " is now removed!");
        System.out.println(list);
        System.out.print("Add first:  ");
        list.addFirst("Anchovie");
        System.out.println(list);
        System.out.println("Size: " + list.size());
        System.out.print("Set the second:  ");
        list.set(2, "Rread");
        System.out.println(list);
    }
}

class DCLNode <E>
{
    private E value;
    private DCLNode prev;
    private DCLNode next;
    public DCLNode(E arg, DCLNode <E> p, DCLNode <E> n)
    {
        value=arg;
        prev=p;
        next=n;
    }
    public DCLNode()
    {
        value=null;
        next=this;
        prev=this;
    }
    public void setValue(E arg)
    {
        value=arg;
    }
    public void setNext(DCLNode <E> arg)
    {
        next=arg;
    }
    public void setPrev(DCLNode <E> arg)
    {
        prev=arg;
    }
    public DCLNode <E> getNext()
    {
        return next;
    }
    public DCLNode <E> getPrev()
    {
        return prev;
    }
    public E getValue()
    {
        return value;
    }
}  // end of DLNode
/********* PROGRAM OUTPUTS ******
 [Apple, Banana, Cucumber, Dumpling, Escargot]
 Size: 5
 [Apple, Banana, Dumpling, Escargot]
 Size: 4
 Removed Cucumber
 Add at 3:   [Apple, Banana, Cheese, Dumpling, Escargot]
 Get values at 1 and first: Apple and Apple
 No change: [Apple, Banana, Cheese, Dumpling, Escargot]
 Apple is now removed!
 [Banana, Cheese, Dumpling, Escargot]
 Add first:  [Anchovie, Banana, Cheese, Dumpling, Escargot]
 Size: 5
 Set the second:  [Anchovie, Rread, Cheese, Dumpling, Escargot]
 **********************************/