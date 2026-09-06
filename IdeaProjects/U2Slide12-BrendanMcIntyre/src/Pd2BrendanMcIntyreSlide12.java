/****************************************************
Brendan McIntyre Period 2
 Day 2 classnotes slide #12
To reinforce understanding of methods and submiting programs
 ****************************************************/
public class Pd2BrendanMcIntyreSlide12 {
    public static void main(String[] args)
    {
        //vaiables
        int x = 8;
        int y = 9;
        int x2 = 2;
        int y2 = 4;
        //prints using variables & methods
        System.out.println("The average of " + x + " and " + y + " is " + average(x,y));

        System.out.println("The slope of the line between (" + x +", " + y + ") and (" +
                x2 + ", " + y2 + ") is " + slope(x, y, x2, y2));
        System.out.println("The distance between (" + x + ", " + y + ") and (" +
                         x2 + ", " + y2 + ") is " + distance(x, y, x2, y2));
    }
    //methods
    //gets average of 2 numbers
    public static double average (int x, int y)
    {

        return (double)(x + y) /2;
    }
    //gets slope of 2 points
    public static double slope (int x1, int y1, int x2, int y2)
    {
        return (double)(y2 - y1)/(x2-x1);
    }
    //subtracts to numbers
    public static int difference (int x, int y)
    {
        return x-y;
    }
    //squares a number
    public static int square (int x)
    {
        return x * x;
    }
    //distance using diffrence and square
    public static double distance (int x1, int y1, int x2, int y2)
    {
        return Math.sqrt(square(difference(x2,x1)) + square(difference(y2,y1)));
    }
}//Pd2BrendanMcIntyreSlide12
/********* PROGRAM OUTPUTS ******
The average between 2 numbers
 The average slope of a line between 2 points
 The distance between 2 points
 **********************************/