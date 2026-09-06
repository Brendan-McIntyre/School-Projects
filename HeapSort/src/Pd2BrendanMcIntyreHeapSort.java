/****************************************************************************
 Name:Brendan McIntyre
 Lab Assignment:HeapSort
 Purpose of the program: The purpose is to understand how to code a heapMax and then do heapSort.

 What I Learned (be as specific as possible): I learned how to create the heapDown method.

 How I feel about this lab: I think this lab was very helpful in getting me better prepared for the test.

 What I am wondering: Why in part 2 it asks for a length of 10 while createRandom() says 100?

 The credits: who and/or what website(s) helped you (must state
 what information you got from the helper or website) None

 Students (names) you helped (to what extent, be specific): None
 ****************************************************************************/


public class Pd2BrendanMcIntyreHeapSort
{
    public static void main(String[] args)
    {
        //Part 1: Given a max heap, sort it. Do this part first.
        double heap[] = {-1,99,80,85,17,30,84,2,16,1};
        display(heap);
        sort(heap);
        display(heap);
        System.out.println(isSorted(heap));

        //Part 2:  Generate 10 random numbers, make a heap, sort it.
        int SIZE = 10;
        double[] heap2 = new double[SIZE + 1];
        heap2 = createRandom(heap2);
        display(heap2);
        makeHeap(heap2);
        display(heap2);
        sort(heap2);
        display(heap2);
        System.out.println(isSorted(heap2));
    }

    //******* Part 1 ******************************************
    // precondition: array is not null and uses index 1 through array.length-1.
    // postcondition: Prints all elements of the array from index 1 to the end.
    public static void display(double[] array)
    {
        for(int k = 1; k < array.length; k++)
            System.out.print(array[k] + "    ");
        System.out.println("\n");
    }

    // precondition: array is not null and represents a max-heap from index 1 to array.length-1.
    // postcondition: Rearranges the array into sorted order (ascending) using heap sort.
    public static void sort(double[] array)
    {
        for(int i = array.length - 1; i > 1; i--){
            swap(array, 1, i);
            heapDown(array, 1, i - 1);
        }
    }

    // precondition: array is not null; indices a and b are valid indexes in the array.
    // postcondition: Swaps the values at indexes a and b in the array.
    public static void swap(double[] array, int a, int b)
    {
        double temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    // precondition: array is not null; k is a valid index; size represents the heap boundary;
    //               subtree rooted at k may violate heap property.
    // postcondition: Restores the max-heap property for the subtree rooted at index k.
    public static void heapDown(double[] array, int k, int size)
    {
        while (k * 2 <= size) {
            int left = k * 2;
            int right = k * 2 + 1;
            int largest = left;

            if (right <= size && array[right] > array[left]) {
                largest = right;
            }

            if (array[k] >= array[largest]) {
                break;
            }

            swap(array, k, largest);
            k = largest;
        }
    }

    // precondition: arr is not null and uses index 1 through arr.length-1.
    // postcondition: Returns true if the array is sorted in ascending order, false otherwise.
    public static boolean isSorted(double[] arr)
    {
        Boolean sorted = true;
        for(int k = 2; k < arr.length; k++){
            if (arr[k-1] > arr[k])
                sorted = false;
        }
        return sorted;
    }

    // ****** Part 2 *******************************************

    //Generate 100 random numbers between 1 and 100, formatted to 2 decimal places
    //postcondition:  array[0] == -1, the rest of the array is random
    public static double[] createRandom(double[] array)
    {
        double [] temp = new double[11];
        temp[0] = -1;
        for(int i = 1; i < temp.length; i++){
            temp[i] = Math.round((1+Math.random() * 99) * 100.0) / 100.0;
        }
        return temp;
    }

    //Turn the random array into a MAX heap
    //postcondition:  array[0] == -1, the rest of the array is in heap-order
    private static void makeHeap(double[] array)
    {
        for(int i = array.length/2; i >= 1; i--){
            heapDown(array, i, array.length-1);
        }
    }

} // HeapSort_shell