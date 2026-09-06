//Name: Brendan McIntyre
//Date: 4/29/26
// What I learned: I learned how to reverse a map structure.
// How I feel about this lab: This lab was a nice simple way to understand reversing a map.
// What I wonder: If Java didn't have Maps then I would use a Set, but I might have the values as
//                  objects so that I can get it as close as possible to Maps.
// Credits: Me


import java.util.*;
public class P2BrendanMcIntyreActingSchool
{
    public static void main(String[] args)
    {

        Map<String, String> sGrades = new HashMap<String, String>();     //HashMap

        sGrades.put("Jack Nicholson", "A-");
        sGrades.put("Humphrey Bogart", "A+");
        sGrades.put("Audrey Hepburn", "A");
        sGrades.put("Meryl Streep", "A-");
        sGrades.put("Jimmy Stewart", "A");

        // What you need to do:
        // 1. display initial data.  Use an iterator instead of using the built-in toString method of HashMap
        Iterator <String> iter = sGrades.keySet().iterator();
        while(iter.hasNext()){
            String temp = iter.next();
            System.out.println(temp + "(" + sGrades.get(temp) + ")");
        }
        System.out.println();
        // 2. reverse the map--use TreeMap
        Map<String, ArrayList<String>> aGrades = new TreeMap<String, ArrayList<String>>();
        for (String item: sGrades.keySet()) {
            if(aGrades.containsKey(sGrades.get(item))){
                aGrades.get(sGrades.get(item)).add(item);
            }
            else{
                aGrades.put(sGrades.get(item), new ArrayList<String>());
                aGrades.get(sGrades.get(item)).add(item);
            }
        }
        // 3. display the reversed map
        Iterator <String> revIter = aGrades.keySet().iterator();
        while(revIter.hasNext()){
            String temp = revIter.next();
            System.out.println(temp + "(" + aGrades.get(temp) + ")");
        }

    } // main
} // ActingSchool_shell