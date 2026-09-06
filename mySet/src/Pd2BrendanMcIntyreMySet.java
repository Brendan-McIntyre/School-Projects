/*****************************************************************************************************************
 NAME: Brendan McIntyre
 PERIOD:2
 DUE DATE: 4/28/26

 PURPOSE: The purpose was to get a better understanding of Sets by not just knowing the data type's methods,
            but to use those methods to grasp the different applications.

 WHAT I LEARNED: I learned that sets can be used to make many different kinds of methods that
                    are very simple to create.

 HOW I FEEL ABOUT THIS LAB: I think it was good to get more practice on Sets, but I also think it
                                was a good refresher on making everything from scratch.


 ****************************************************************************************************************/
import java.util.Set;
import java.util.HashSet;

public class Pd2BrendanMcIntyreMySet
{
    public static void main(String[] args)
    {
        MySet<Integer> s1 = new MySet<>();
        MySet<Integer> s2 = new MySet<>();

        s1.add(1);
        s1.add(2);
        s1.add(3);
        s1.add(4);

        s2.add(1);
        s2.add(2);
        s2.add(3);
        s2.add(4);
        s2.add(5);
        s2.add(6);

        System.out.println("Set 1: " + s1);
        System.out.println("Set 2: " + s2);

        System.out.println("\nUnion:");
        System.out.println(s1.union(s2.getSet()));

        System.out.println("\nIntersection:");
        System.out.println(s1.intersect(s2.getSet()));

        System.out.println("\nDifference (s1 - s2):");
        System.out.println(s1.difference(s2.getSet()));

        System.out.println("\nIs Set 1 a subset of Set 2?");
        System.out.println(s1.subset(s2.getSet()));

        System.out.println("\nIs Set 1 a superset of Set 2?");
        System.out.println(s1.superset(s2.getSet()));
    }
}

class MySet<E> {

    private Set<E> data;

    // precondition: None.
    // postcondition: Initializes an empty set.
    public MySet(){
        data = new HashSet<>();
    }

    // precondition: None.
    // postcondition: Adds item to the set if it is not already present.
    public void add(E item){
        data.add(item);
    }

    // precondition: s is not null.
    // postcondition: Returns a new set containing all elements from this set and s (union).
    public Set<E> union(Set<E> s){
        Set<E> result = new HashSet<>(data);
        for (E item : s){
            if(!data.contains(item))
                result.add(item);
        }
        return result;
    }

    // precondition: s is not null.
    // postcondition: Returns a new set containing only elements common to both sets (intersection).
    public Set<E> intersect(Set<E> s){
        Set<E> result = new HashSet<>();
        for (E item : s){
            if(data.contains(item))
                result.add(item);
        }
        return result;
    }

    // precondition: s is not null.
    // postcondition: Returns a new set containing elements in this set but not in s (difference).
    public Set<E> difference(Set<E> s){
        Set<E> result = new HashSet<>(data);
        for (E item : s){
            result.remove(item);
        }
        return result;
    }

    // precondition: s is not null.
    // postcondition: Returns true if this set is a subset of s; otherwise false.
    public boolean subset(Set<E> s){
        for (E item : data){
            if(!s.contains(item)){
                return false;
            }
        }
        return true;
    }

    // precondition: s is not null.
    // postcondition: Returns true if this set is a superset of s; otherwise false.
    public boolean superset(Set<E> s){
        for (E item : s){
            if(!data.contains(item)){
                return false;
            }
        }
        return true;
    }

    // precondition: None.
    // postcondition: Returns the underlying set.
    public Set<E> getSet(){
        return data;
    }

    // precondition: None.
    // postcondition: Returns a string representation of the set in [a, b, c] format.
    public String toString(){
        String result = "[";

        for (E item : data){
            result += item + ", ";
        }

        if (!data.isEmpty()){
            result = result.substring(0, result.length() - 2);
        }
        result += "]";
        return result;
    }
}