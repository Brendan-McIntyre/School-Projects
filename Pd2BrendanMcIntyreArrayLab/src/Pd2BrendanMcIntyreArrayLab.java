// Name:  Brendan McIntyre   Period: 2    Date: 12/9/24
//
// Mistakes made:
//
public class Pd2BrendanMcIntyreArrayLab
{
    //pre-condition: None
    // post condition: find and return the max element in list
    public static int findMax(int [] array)
    {
        return array[findMaxIndex(array)];
    }

    //pre-condition: None
    // post condition: find and return the index of the max element in array
    public static int findMaxIndex(int [] array)
    {
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] > array[index]) {
                index = i;
            }
        }
        return index;
    }

    //pre-condition: None
    // post condition: find and return the min element in array
    public static int findMin(int [] array)
    {
        return array[findMinIndex(array)];
    }

    //pre-condition: None
    // post condition: find and return the index of the min element in array
    public static int findMinIndex(int [] array)
    {
        int index = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] < array[index]) {
                index = i;
            }
        }
        return index;
    }

    //pre-condition: None
    // post condition: check to see if target can be found array or not.
    //                 If yes, returns true; otherwise, returns false.
    public static boolean find (int [] array, int target)
    {
        for(int number : array) {
            if (number == target) {
                return true;
            }
        }
        return false;
    }

    //pre-condition: None
    // post condition: put all the negative numbers in  an array and return it
    // Hint:
    // Step 1: Use a for loop to find out how many negative numbers are in array
    // Step 2: Use that number to create an int array of that size
    // Step 3: Use a for loop to traverse array and whenever a negative number is found,
    //         store that number in the newly created negative array.
    public  static int [] negArray (int [] array)
    {
        int negCount = 0;
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] < 0) {
                negCount++;
            }
        }
        int [] neg = new int [negCount];
        for(int i = 0; i < array.length; i++){
            if (array[i] < 0) {
                neg[count] = array[i];
                count++;
            }
        }
        return neg;
    }

    //pre-condition: None
    // post condition: put all the positive numbers in list in an array and return the array
    public  static int [] posArray(int [] array)
    {
        int posCount = 0;
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] > 0) {
                posCount++;
            }
        }
        int [] pos = new int [posCount];
        for(int i = 0; i < array.length; i++){
            if (array[i] > 0) {
                pos[count] = array[i];
                count++;
            }
        }
        return pos;
    }

    //pre-condition: None
    // post condition: sum up all the numbers in list and return the sum
    public  static int sum (int [] array)
    {
        int sum = 0;
        for(int number : array) {
            sum += number;
        }
        return sum;
    }

    //pre-condition: None
    // post condition: find the average of all the numbers in list
    public  static double average(int [] array)
    {
        return (double)sum(array)/array.length;
    }

    //pre-condition: None
    // post condition: put all the even numbers in list and return the array
    public   static int [] evenMembers(int [] array)
    {
        int evenCount = 0;
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0) {
                evenCount++;
            }
        }
        int [] even = new int [evenCount];
        for(int i = 0; i < array.length; i++){
            if (array[i] % 2 == 0) {
                even[count] = array[i];
                count++;
            }
        }
        return even;

    }

    //pre-condition: None
    // post condition: put all the odd numbers in list  and return the array
    public   static int [] oddMembers(int [] array)
    {
        int oddCount = 0;
        int count = 0;
        for(int i = 0; i < array.length; i++){
            if (array[i] % 2 != 0) {
                oddCount++;
            }
        }
        int [] odd = new int [oddCount];
        for(int i = 0; i < array.length; i++){
            if (array[i] % 2 != 0) {
                odd[count] = array[i];
                count++;
            }
        }
        return odd;
    }

    //pre-condition: None
    // post condition: rotate the array clockwise n number of times and return
    //                 the rotated array. The original array remains unchanged.
    //                 Example: array is {1,13,9,8}
    //                          rotateClockwise (array, 1) returns:
    //                          {13,9,8,1}
    //                          rotateClockwise (array, 2) returns:
    //                          {9,8,1,13}
    public static  int [] rotateClockwise(int [] array, int n)
    {
        int [] copy = new int [array.length];
        for (int i = 0; i < array.length; i++){
            copy[i] = array[(i + n) % array.length];
        }
        return copy;
    }

    //pre-condition: None
    // post condition: print all the elements (each separated by a space) in array
    //                 on the console--ten numbers per line
    public static void printArray (String prompt, int [] array)
    {
        System.out.print (prompt);
        for(int number : array) {
            System.out.print(number + ", ");
        }
    }

    //********************************************************
    public static void main(String[] args)
    {
        int [] list = {15, -5, 25, 75, 9, -2, -80, -100, 99, 21,
                23, 40, 45, 67,100, 44, 28, 1, 3};

        String prompt = "Original list:\n";
        printArray(prompt, list);

        System.out.println ("\nMax value: " + findMax(list));  // output: 100
        System.out.println ("Min value: " + findMin(list));    // output: -100

        System.out.println ("\nIndex of maximum element: " + findMaxIndex(list)); //output: 8
        System.out.println ("\nIndex of minimum element: " + findMinIndex(list)); //output: 7

        System.out.println ("The statement \"3 is in the array\" is: " + find (list, 3));

        prompt = "\nPositive elements in the array are:\n";
        printArray(prompt, posArray(list));

        prompt = "\nNegative elements in the array are:\n";
        printArray(prompt, negArray(list));

        prompt = "\nEven elements in the array are:\n";
        printArray(prompt, evenMembers(list));

        prompt = "\nOdd elements in the array are:\n";
        printArray(prompt,oddMembers(list));

        System.out.println("\nSum of all elements: " + sum(list));
        System.out.println("Average of all elements: " + average(list));

        prompt = "\nRotate clockwise 2 times and the new array is:\n";
        printArray(prompt, rotateClockwise(list, 2));

        prompt = "\nOriginal list:\n";
        printArray(prompt, list);

        prompt = "\nRotate clockwise 0 time and the new array is:\n";
        printArray(prompt, rotateClockwise(list, 0));
    }  // main

} // Pd2BrendanMcIntyreArrayLab

