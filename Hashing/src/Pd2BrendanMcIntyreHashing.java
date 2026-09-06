/*****************************************************************************************************************
 NAME: Brendan McIntyre
 PERIOD: 2
 DUE DATE: 4/22/26

 PURPOSE: The purpose was to introduce relatively prime hash tables and practice linear & chaining hash tables.

 WHAT I LEARNED: I learned how to apply the processes I learned in class to make an actual program.

 CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITE): None

 ****************************************************************************************************************/
/***********************************************************************************
 Assignment:  This hashing program results in collisions.
 You are to implement three different collision schemes:
 linear probing, relative prime probing (use the first relatively prime
 number of the length of the hash table as the step increase), and
 chaining.  Then implement a search algorithm that is appropriate
 for each collision scheme.
 ***********************************************************************************/
import java.util.*;
import javax.swing.*;

public class Pd2BrendanMcIntyreHashing
{
    public static void main(String[] args)
    {
        int arrayLength = Integer.parseInt(JOptionPane.showInputDialog(
                "Hashing!\n"+
                        "Enter the size of the array:  ")); // enter 20

        int numItems = Integer.parseInt(JOptionPane.showInputDialog(
                "Add n items:  "));                 // enter 15

        int scheme = Integer.parseInt(JOptionPane.showInputDialog(
                "The Load Factor is " + (double)numItems/arrayLength +
                        "\nWhich collision scheme?\n"+
                        "1. Linear Probing\n" +
                        "2. Relatively Prime Probing\n"+
                        "3. Chaining"));
        Hashtable table = null;
        switch( scheme )
        {
            case 1:
                table = new HashtableLinearProbe(arrayLength);
                break;
            case 2: // rehash using the first relatively prime of arrayLength
                table = new HashtableRelativePrime(arrayLength);
                break;
            case 3:
                table = new HashtableChaining(arrayLength);
                break;
            default:  System.exit(0);
        }
        for(int i = 0; i < numItems; i++)
            table.add("Item" + i);
        String action = JOptionPane.showInputDialog(
                "Search for:  Item0" + " to "+ "Item"+(numItems-1));
        int itemNumber = 0;
        if (action != null)
        {
            itemNumber = Integer.parseInt(action);
            while( itemNumber != -1 )
            {
                String key = "Item" + itemNumber;
                int index = table.indexOf(key);
                if( index >= 0)    //found it
                    System.out.println(key + " found  at index " + index);
                else
                    System.out.println(key + " not found!");
                action = JOptionPane.showInputDialog(
                        "Search for:  Item0" + " to "+ "Item"+(numItems-1));
                if (action != null)
                    itemNumber = Integer.parseInt(action);
                else
                    itemNumber = -1;
            }
        }
        System.out.println ("Goodbye!");
        System.exit(0);
    } // main
} // Hashing

interface Hashtable
{
    void add(Object obj);
    int indexOf(Object obj);
}


class HashtableLinearProbe implements Hashtable
{
    private Object[] array;

    // precondition: size > 0.
    // postcondition: Initializes an empty hash table of given size.
    public HashtableLinearProbe(int size)
    {
        array = new Object[size];
    }

    // precondition: obj is not null.
    // postcondition: Inserts obj into the table using linear probing if needed.
    public void add(Object obj)
    {
        int code = obj.hashCode();
        int index = Math.abs(code % array.length);
        if (array[index] == null)  //empty
        {
            array[index] = obj;//insert it
            System.out.println(obj + "\t" + code + "\t" + index);
        }
        else    //collision
        {
            System.out.println(obj + "\t" + code + "\tCollision at "+ index);
            index = linearProbe(index);
            array[index] = obj;
            System.out.println(obj + "\t" + code + "\t" + index);
        }
    }

    // precondition: index is a valid index in the array.
    // postcondition: Returns the next available empty index using linear probing.
    public int linearProbe(int index)
    {
        while(array[index] != null){
            index = (index + 1) % array.length;
        }
        return index;
    }

    // precondition: obj is not null.
    // postcondition: Returns the index of obj if found, otherwise returns -1.
    public int indexOf(Object obj)
    {
        int index = Math.abs(obj.hashCode() % array.length);
        while(array[index] != null)
        {
            if(array[index].equals(obj))  //found it
            {
                return index;
            }
            else    //search for it in a linear probe manner
            {
                index = (index + 1) % array.length;
                System.out.println("Looking at index " + index);
            }
        } // while
        return -1;//not found
    } // indexOf
} // HashtableLinearProbe



class  HashtableRelativePrime implements Hashtable
{
    private Object[] array;
    private int constant = 2;

    // precondition: size > 0.
    // postcondition: Initializes array and finds a relatively prime constant.
    public  HashtableRelativePrime(int size)
    {
        //constructor
        array = new Object[size];
        //find a constant that is relatively prime to the size of the array
        while (array.length % constant == 0){
            constant++;
        }
    }

    // precondition: obj is not null.
    // postcondition: Inserts obj using relative prime probing.
    public void add(Object obj)
    {
        int code = obj.hashCode();
        int index = Math.abs(code % array.length);
        if(array[index] == null)  //empty
        {
            array[index] = obj;
            System.out.println(obj + "\t" + code + "\t" + index);
        }
        else //collision
        {
            System.out.println(obj + "\t" + code + "\tCollision at "+ index);

            // keep probing until empty (fix)
            while(array[index] != null){
                index = rehash(index);
            }

            array[index] = obj;
            System.out.println(obj + "\t" + code + "\t" + index);
        }
    }

    // precondition: index is a valid index in the array.
    // postcondition: Returns a new index using relative prime step size.
    public int rehash(int index)
    {
        return (index + constant) % array.length;
    }

    // precondition: obj is not null.
    // postcondition: Returns index if found, otherwise -1.
    public  int indexOf(Object obj)
    {
        int index = Math.abs(obj.hashCode() % array.length);
        while(array[index] != null)
        {
            if(array[index].equals(obj))  //found it
            {
                return index;
            }
            else //search for it in a rehashing manner
            {
                index = rehash(index);
                System.out.println("Looking at index " + index);
            }
        }
        return -1;
        //not found
    }
} //  HashtableRelativePrime



class HashtableChaining implements Hashtable
{
    private LinkedList[] array;

    // precondition: size > 0.
    // postcondition: Initializes the array and each LinkedList.
    public HashtableChaining(int size)
    {
        //instantiate the array
        //instantiate the LinkedLists
        array = new LinkedList[size];
        for(int i = 0; i < size; i++){
            array[i] = new LinkedList<>();
        }
    }

    // precondition: obj is not null.
    // postcondition: Adds obj to the front of the linked list at its hash index.
    public void add(Object obj)
    {
        int code = obj.hashCode();
        int index = Math.abs(code % array.length);
        array[index].addFirst(obj);
        System.out.println(obj + "\t" + code + " " + " at " +index + ": "+ array[index]);
    }

    // precondition: obj is not null.
    // postcondition: Returns the index where obj is found, or -1 if not found.
    public int indexOf(Object obj)
    {
        int index = Math.abs(obj.hashCode() % array.length);
        if( !array[index].isEmpty() )
        {
            if(array[index].getFirst().equals(obj))  //found it
            {
                return index;
            }
            else //search for it in a chaining manner
            {
                for (Object o : array[index]) {
                    if(o.equals(obj)){
                        return index;
                    }
                }
            }
        }
        //not found
        return -1;
    } // indexOf
} // HashtableChaining