/**************************************************************************************
 Name:Brendan McIntyre
 Date:3/17/26
 What I learned: I learned how to make min-heaps and adjust them when adding or removing to keep
                  it a min-heap.
 How I feel about this lab: I feel like this lab was a little confusing because there wasn't anything
                            specific about only doing a min-heap.

 I am wondering (the what-if moment): Can you make this for both min and max without having a variable
                                        to show which one it is?
 ***************************************************************************************/

public class Pd2BrendanMcIntyreHeapOneDArray_PriorityQueue <E extends Comparable <E>>
{
    private static final int DEFAULT_CAPACITY = 1024;
    private Comparable [] items;      // use a 1-D array instead of ArrayList
    private int numItems;    // number of elements in items


    public static void main (String [] args)
    {
        // Create a Pd2BrendanMcIntyreHeapOneDArray_PriorityQueue object to test all the methods in this class
        Pd2BrendanMcIntyreHeapOneDArray_PriorityQueue <Integer> pq = new Pd2BrendanMcIntyreHeapOneDArray_PriorityQueue <>(4);
        pq.add(52);
        pq.add(5);
        pq.add(32);
        pq.add(12);
        pq.add(20);

        System.out.print("Heap: ");
        System.out.println(pq);

        System.out.println("Heap min: " + pq.peek());

        System.out.println("Removed min: " + pq.remove());

        System.out.print("Heap after remove:");
        System.out.println(pq);

        pq.add(3);
        pq.add(40);
        System.out.print("Heap:");
        System.out.println(pq);

        System.out.println("Removed min: " + pq.remove());
        System.out.print("Heap:");
        System.out.print(pq);
    }

    public Pd2BrendanMcIntyreHeapOneDArray_PriorityQueue()
    {
        items = new Comparable [DEFAULT_CAPACITY];
        numItems = 0;
    }

    public Pd2BrendanMcIntyreHeapOneDArray_PriorityQueue (int initialCapacity)
    {
        items = new Comparable [initialCapacity];
        numItems = 0;
    }

    // precondition: None.
    // postcondition: Returns true if the heap is empty, false otherwise.
    public boolean isEmpty()
    {
        return numItems == 0;
    }

    // precondition: Heap is not empty.
    // postcondition: Returns the minimum element in the heap without removing it; null if heap is empty.
    public E peek()
    {
        if(isEmpty())
            return null;
        return (E)items[1];
    }

    // precondition: Heap is not empty.
    // postcondition: Removes and returns the minimum element from the heap and maintains heap property.
    public E remove()
    {
        E item = (E)items[1];
        items[1] = items[numItems];
        items[numItems] = null;
        numItems = numItems - 1;
        reheapDown(1);
        return item;
    }

    // precondition: obj is not null and implements Comparable.
    // postcondition: Adds obj to the heap, doubles array size if needed, and maintains heap property.
    public boolean add(E obj)
    {
        if(numItems == items.length-1)
            doubleCapacity();
        items[numItems+1] = obj;
        numItems++;
        reheapUp();
        return true;

    } // add

    // precondition: None.
    // postcondition: Returns a comma-separated string of heap elements from index 1 to numItems.
    public String toString ()
    {
        String temp = "";
        for (int i = 1; i < numItems;i++){
            temp+= items[i] +", ";
        }
        temp+= items[numItems];
        return temp;
    }

    // precondition: index is a valid index in the heap (1 <= index <= numItems).
    // postcondition: Restores heap property for subtree rooted at index by moving element down as needed.
    private void reheapDown(int index)
    {
        while (2 * index <= numItems){
            int child = 2 * index;
            if (child < numItems && (items[child + 1]).compareTo(items[child]) < 0){
                child++;
            }

            if ((items[index]).compareTo(items[child]) <= 0)
                break;

            Comparable temp = items[index];
            items[index] = items[child];
            items[child] = temp;
            index = child;
        }
    }

    // precondition: numItems >= 1.
    // postcondition: Restores heap property by moving last element up to correct position.
    private void reheapUp()
    {
        int index = numItems;
        while (index > 1 && items[index].compareTo(items[index / 2]) < 0){
            Comparable temp = items[index / 2];
            items[index / 2] = items[index];
            items[index] = temp;
            index = index / 2;

        }
    }

    // precondition: Called when items array is full.
    // postcondition: Doubles the capacity of the items array, preserving all current elements.
    private void doubleCapacity()
    {
        Comparable[] temp = new Comparable[items.length*2];
        for (int i = 1; i <= numItems; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

}  //Pd2BrendanMcIntyreHeapOneDArray_PriorityQueue
/********* PROGRAM OUTPUTS ******
 Heap: 5, 12, 32, 52, 20,
 Heap min: 5
 Removed min: 5
 Heap after remove:12, 20, 32, 52,
 Heap:3, 12, 32, 52, 20, 40,
 Removed min: 3
 Heap:12, 20, 32, 52, 40,
 **********************************/