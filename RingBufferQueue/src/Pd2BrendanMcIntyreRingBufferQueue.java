/*****************************************************************************************************************
 NAME: Brendan McIntyre
 PERIOD: 2
 DUE DATE:2/5/26
 ASSIGNMENT: RingBufferQueue Program

 PURPOSE: The purpose was to get a better understanding of Ring Buffer implementation of Queue.

 LEARNED:
 - I learned how to use Ring Buffer implementation of Queue
 ****************************************************************************************************************/
class Main{
    public static void main(String[] args) {
        Pd2BrendanMcIntyreRingBufferQueue<Integer> q = new Pd2BrendanMcIntyreRingBufferQueue<>();
        q.add(50);
        q.add(76);
        q.add(87);
        q.add(99);
        q.add(6);
        q.add(23);
        q.remove();
        q.add(12);
        q.add(345);
        q.add(567);
        q.add(987);
        q.add(8764);
        q.add(8540);
        q.ToString();
        System.out.println(q.peek());
    }
}
public class Pd2BrendanMcIntyreRingBufferQueue <E> {
    private E[] q;
    private int front, rear;   // rear points to next available empty slot
    private int size = 10;
    private boolean full = false;

    // Precondition: none
    // Postcondition: creates an empty ring buffer queue with initial capacity of 10
    public Pd2BrendanMcIntyreRingBufferQueue() {
        q = (E[]) (new Object[size]);
        front = 0;
        rear = 0;
    }

    // Precondition: v is a valid element of type E
    // Postcondition: adds v to the rear of the queue; resizes the buffer if full
    public void add(E v) {
        if (full == true) {
            resize();
        }
        q[rear] = v;
        rear = (rear + 1) % size;
        if(front == rear){
            full = true;
        }
    }

    // Precondition: queue is not empty
    // Postcondition: removes and returns the element at the front of the queue
    public E remove() {
        E r = q[front];
        if (full == true)
            full = false;
        front = (front + 1) % size;
        return r;
    }

    // Precondition: queue is not empty
    // Postcondition: returns the element at the front of the queue without removing it
    public E peek() {
        return q[front];
    }

    // Precondition: none
    // Postcondition: returns true if the queue is empty; false otherwise
    public boolean isEmpty() {
        return front == rear && !full;
    }

    // Precondition: queue is full
    // Postcondition: doubles the size of the buffer, copies elements in order,
    //                resets front to 0, rear to next empty slot, and sets full to false
    public void resize() {
        E[] temp = (E[]) new Object[size * 2];

        int count;
        if (full) {
            count = size;
        } else if (rear >= front) {
            count = rear - front;
        } else {
            count = size - front + rear;
        }

        for (int i = 0; i < count; i++) {
            temp[i] = q[(front + i) % size];
        }

        q = temp;
        front = 0;
        rear = count;
        size *= 2;
        full = false;
    }

    // Precondition: none
    // Postcondition: prints the elements of the queue from front to rear in order
    public void ToString (){
        int count;
        if (full) {
            count = size;
        } else if (rear >= front) {
            count = rear - front;
        } else {
            count = size - front + rear;
        }

        for (int i = 0; i < count; i++) {
            System.out.print(q[(front + i) % size] + ", ");
        }
        System.out.println();
    }
}
/******************|Output|*************************
 * 76, 87, 99, 6, 23, 12, 345, 567, 987, 8764, 8540,
 * 76
 */