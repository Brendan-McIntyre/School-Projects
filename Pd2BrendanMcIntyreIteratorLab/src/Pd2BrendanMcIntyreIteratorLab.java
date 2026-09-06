/*****************************************************************************************************************
 NAME: Brendan McIntyre
 PERIOD: 2
 DUE DATE: 12/11/25
 ASSIGNMENT: Iterator Lab

 PURPOSE:
The purpose was to understand how to use Iterators.
 WHAT I LEARNED:
 I learned how to use listIterators.
 ****************************************************************************************************************/

// NOTE:  Use only for-each loops or iterators, NOT regular for-loops
//        Points will be taken off if regular for loops are used.
import java.io.*;
import java.util.*;
public class Pd2BrendanMcIntyreIteratorLab
{
    public static void main(String[] args)
    {
        System.out.println("Iterator Lab\n");
        int[] rawNumbers = {-9, 4, 2, 5, -10, 6, -4, 24, 20, -28};
        for(int n : rawNumbers )
            System.out.print(n + " ");
        ArrayList<Integer> numbers = createNumbers(rawNumbers);
        System.out.println();
        System.out.println("ArrayList: "+ numbers);      //Implicit Iterator!
        System.out.println("Count negative numbers: " + countNeg(numbers));
        System.out.println("Average: " + average(numbers));
        System.out.println("Replace negative numbers: " + replaceNeg(numbers));
        System.out.println("Delete zeros: " + deleteZero(numbers));
        String[] rawMovies = {"High_Noon", "High_Noon", "Star_Wars", "Tron", "Mary_Poppins",
                "Dr_No", "Dr_No", "Mary_Poppins", "High_Noon", "Tron"};
        ArrayList<String> movies = createMovies(rawMovies);
        System.out.println("Movies: " + movies);
        System.out.println("Movies: " +  removeDupes(movies));
    }
    // pre: an array of just int values
    // post: return an ArrayList containing all the values
    public static ArrayList<Integer> createNumbers(int[] rawNumbers)
    {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = rawNumbers.length-1; i >= 0;i--){
            numbers.add(rawNumbers[i]);
        }
        return numbers;
    }
    // pre: an array of just Strings
    // post: return an ArrayList containing all the Strings
    public static ArrayList<String> createMovies(String[] rawWords)
    {
        ArrayList<String> movies = new ArrayList<>();
        for(String movie : rawWords){
            movies.add(movie);
        }
        return movies;
    }
    // pre: ArrayList a is not empty and contains only Integer objects
    // post: return the number of negative values in the ArrayList a
    public static int countNeg(ArrayList<Integer> a)
    {
        int negative = 0;
        for(int num : a){
            if(num < 0){
                negative++;
            }
        }
        return negative;
    }
    // pre: ArrayList a is not empty and contains only Integer objects
    // post: return the average of all values in the ArrayList a
    public static double average(ArrayList<Integer> a)
    {
        int total = 0;
        for(int num : a){
            total+= num;
        }
        return total/(double)a.size();
    }

    // NOTE: in this method, you must use an iterator, NO for-each loop
    // pre: ArrayList a is not empty and contains only Integer objects
    // post: replaces all negative values with 0
    public static ArrayList<Integer> replaceNeg(ArrayList<Integer> a)
    {
        ListIterator <Integer> num = a.listIterator();
        while(num.hasNext()){
            if(num.next() < 0){
                num.set(0);
            }
        }
        return a;
    }

    // NOTE: in this method, you must use an iterator, NO for-each loop
    // pre: ArrayList a is not empty and contains only Integer objects
    // post: deletes all zeros in the ArrayList a
    public static ArrayList<Integer> deleteZero(ArrayList<Integer> a)
    {
        ListIterator <Integer> num = a.listIterator();
        while(num.hasNext()){
            if(num.next() == 0){
                num.remove();
            }
        }
        return a;
    }
    // pre: ArrayList a is not empty and contains only String objects
    // post: return ArrayList without duplicate movie titles
    // strategy: start with an empty array and add movies as needed
    public static ArrayList<String> removeDupes(ArrayList<String> a)
    {
        ArrayList <String> movies = new ArrayList<>();
        for (String movie : a) {
            if(!movies.contains(movie)){
                movies.add(movie);
            }
        }
        return movies;
    }
}
/**************************
 Output:
 Iterator Lab

 -9 4 2 5 -10 6 -4 24 20 -28
 ArrayList: [-28, 20, 24, -4, 6, -10, 5, 2, 4, -9]
 Count negative numbers: 4
 Average: 1.0
 Replace negative numbers: [0, 20, 24, 0, 6, 0, 5, 2, 4, 0]
 Delete zeros: [20, 24, 6, 5, 2, 4]
 Movies: [High_Noon, High_Noon, Star_Wars, Tron, Mary_Poppins, Dr_No, Dr_No, Mary_Poppins, High_Noon, Tron]
 Movies: [High_Noon, Star_Wars, Tron, Mary_Poppins, Dr_No]
 *************************/