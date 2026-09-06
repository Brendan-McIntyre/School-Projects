/***********************************************************************************************************************************************
 Name:Brendan McIntyre
 Period:2
 * Name of the Lab: Area Fill
 * Purpose of the Program: Better understand the uses and properties of recursion
 * Due Date: 10/10/25
 * Date Submitted:10/9/25
 * What I learned:
 *    I learned that it is ok to have a helper method because sometimes you need one.
 * How I feel about this lab:
 *    I think this lab was interesting the way you make a character spread around the area with recursion.
 * What I wonder:
 *    What are some more interesting ways that recursion can be used efficiently?
 *************************************************************************************************************************************************/


import java.util.Scanner;
import java.io.*;
public class Pd2BrendanMcIntyreAreaFill
{
    public static char[][] grid = null;

    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Filename: ");
        String filename = sc.next();
        grid = read(filename + ".txt");
        display(grid);
        System.out.println("\nEnter ROW COL to fill from: ");
        int row = sc.nextInt();
        int col = sc.nextInt();
        System.out.print("Enter Character: ");
        char ch = sc.next().charAt(0);
        fill(grid, row, col, ch);
        display(grid);
        sc.close();
    }
    public static char[][] read(String filename)throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File(filename));
        char[][] board = new char[sc.nextInt()][sc.nextInt()];
        for(int i = 0; i < board.length; i++) {
            String row = sc.next();
            board[i] = row.toCharArray();
        }
        return board;
    }

    public static void display(char[][] g)
    {
        for(int i = 0; i < g.length; i++) {
            for(int j = 0; j < g[i].length; j++) {
                System.out.print(g[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * pre: method called in main method
     * post: modifies char[][] g and replaces characters of the
     * index indicated on the grid with a *
     * @param g
     * @param r
     * @param c
     * @param ch
     */


    /**
     * pre:  The method is called with a valid 2D grid and valid row and column indices.
     *       The character `ch` is the character to fill the area with.
     * post: All contiguous cells (up, down, left, right) starting from (r, c)
     *       that contain the original character are replaced with `ch`.
     */
    public static void fill(char[][] g, int r, int c, char ch)
    {
        if (r < 0 || r >= g.length || c < 0 || c >= g[0].length)
            return;

        char target = grid[r][c];
        if (target == ch)
            return;

        fillHelper(g, r, c, target, ch);
    }//fill

    /**
     * pre:  The method is called by `fill()` with a valid grid, row, and column,
     *       and `target` is the original character to be replaced.
     * post: Recursively replaces all connected cells containing `target` with `fillChar`.
     */
    private static void fillHelper(char[][] g, int r, int c, char target, char fillChar) //recursive method
    {
        if (r < 0 || r >= g.length || c < 0 || c >= g[0].length)
            return;
        if (g[r][c] != target)
            return;

        g[r][c] = fillChar;
        fillHelper(g, r - 1, c, target, fillChar);
        fillHelper(g, r + 1, c, target, fillChar);
        fillHelper(g, r, c - 1, target, fillChar);
        fillHelper(g, r, c + 1, target, fillChar);
    }//fillHelper
}