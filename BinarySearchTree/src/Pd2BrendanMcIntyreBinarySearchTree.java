/*****************************************************************************************************************
 NAME: Brendan McIntyre
 PERIOD:2
 DUE DATE: 3/2/26

 PURPOSE: Practice how to get the minimum, maximum, searching, and inserting nodes in a BST.

 WHAT I LEARNED: This lab made me remember that you need to set the original and not just the
                 copy to the new changes of the data set.

 HOW I FEEL ABOUT THIS LAB: This lab was good practice for creating and analysing BSTs.


 ****************************************************************************************************************/
import java.util.Scanner;
/****************************************************************
 Practice with a Binary Search Tree. Uses TreeNode.
 Prompt the user for an input string.  Build a Binary Search Tree
 using Comparables.  Display it as a sideways tree (take the code
 from the Tree Lab).  Prompt the user for a target and search the tree
 for it.  Display the tree's minimum and maximum values.  Print
 the data in order from smallest to largest.
 *****************************************************************/
public class Pd2BrendanMcIntyreBinarySearchTree
{
    public static void main(String[] args)
    {
        BinarySearchTree <String> t = new BinarySearchTree <> ();

        // build the tree
        Scanner sc = new Scanner(System.in);
        System.out.print("Input string: ");
        String s = sc.next();               // Try these three strings: es"MAENIRAC";  "AMERICAN";   "AACEIMNR"
        for(int k = 0; k < s.length(); k++)
            t.insert ("" + s.charAt (k));
        // get the root of the newly created BinarySearchTree
        TreeNode <String> root = t.getRoot();

        // call the display sideway method
        t.display();

        // test the find method
        sc = new Scanner(System.in);
        System.out.print("Input target: ");
        String target =  sc.next();             //"I"

        boolean itemFound = t.find(target);
        if(itemFound)
            System.out.println("found: " + target);
        else
            System.out.println(target +" not found.");

        // test the min and max methods
        System.out.println("Min = " + t.min());
        System.out.println("Max = " + t.max());

        // inorder traversal display the values from smallest to largest
        System.out.println("\nIn Order: ");
        t.smallToLarge();
    }
}
class BinarySearchTree <E extends Comparable <E>>
{
    private TreeNode <E> root;

    // Precondition: None.
    // Postcondition: Returns the root node of the BST, or null if the tree is empty.
    public TreeNode <E> getRoot()
    {
        return root;
    }

    /****************************************************************
     Recursive algorithm to build a BST:  if the node is null, insert the
     new node.  Else, if the item is less, set the left node and recur to
     the left.  Else, if the item is greater, set the right node and recur
     to the right.
     *****************************************************************/

    // Precondition: s is not null and implements Comparable.
    // Postcondition: Inserts s into the BST in the correct location and updates root if needed.
    public TreeNode <E> insert(E s)
    {
        root = insert (root, s);
        return root;
    }

    // Precondition: t is the root of a subtree (may be null); s is not null.
    // Postcondition: Returns the subtree root after inserting s in correct BST position.
    private TreeNode <E> insert(TreeNode <E> t, E s)
    {
        if(t == null)
            return new TreeNode <E> (s);

        if(t.getValue().compareTo(s) < 0){
            t.setRight(insert(t.getRight(), s));
        }
        else{
            t.setLeft(insert(t.getLeft(), s));
        }
        return t;
    } // insert


    // Precondition: None.
    // Postcondition: Displays the BST sideways.
    public void display ()
    {
        display (root, 0);
    }

    // display helper method and it is a private method

    // Precondition: t is a node in the BST (may be null); level represents depth.
    // Postcondition: Prints the subtree rooted at t sideways.
    private void display(TreeNode <E> t, int level)
    {
        if(t == null)
            return;
        display(t.getRight(), level + 1);
        System.out.println(t.getValue());
        display(t.getLeft(), level + 1);
        // your code goes here
    }

    /***************************************************************
     Iterative algorithm:  create a temporary pointer p at the root.
     While p is not null, if the p's value equals the target, return true.
     If the target is less than the p's value, go left, otherwise go right.
     If the target is not found, return false.

     Find the target. Recursive algorithm:  If the tree is empty,
     return false.  If the target is less than the current node
     value, return the left subtree.  If the target is greater, return
     the right subtree.  Otherwise, return true.
     . ****************************************************************/

    // Precondition: x is not null and comparable to elements in the BST.
    // Postcondition: Returns true if x exists in the BST, false otherwise.
    public  boolean find(E x)
    {
        return find (root, x);
    }

    // helper method of find

    // Precondition: t is a subtree root (may be null); x is not null.
    // Postcondition: Returns true if x exists in the subtree rooted at t.
    private boolean find (TreeNode <E> t, E x)
    {
        if(t == null)
            return false;
        if(t.getValue().equals(x)){
            return true;
        }
        else {
            return find(t.getRight(), x) || find(t.getLeft(), x);
        }
    }

    /***************************************************************
     starting at the root, return the min value in the BST.
     Use iteration.   Hint:  look at several BSTs. Where are
     the min values always located?
     ***************************************************************/

    // Precondition: None.
    // Postcondition: Returns the minimum value in the BST, or null if empty.
    public  E min()
    {
        return min(root);
    }

    // Precondition: t is a subtree root (may be null).
    // Postcondition: Returns the minimum value in subtree rooted at t.
    public E min (TreeNode <E> t){
        if(t == null)
            return null;
        if(t.getLeft() == null)
            return t.getValue();
        return min(t.getLeft());
    }

    /*****************************************************************
     starting at the root, return the max value in the BST.
     Use recursion!
     *****************************************************************/

    // Precondition: None.
    // Postcondition: Returns the maximum value in the BST, or null if empty.
    public  E max()
    {
        return max(root);
    }

    // Precondition: t is a subtree root (may be null).
    // Postcondition: Returns the maximum value in subtree rooted at t.
    public E max (TreeNode <E> t){
        if(t == null)
            return null;
        if(t.getRight() == null)
            return t.getValue();
        return max(t.getRight());
    }

    // Precondition: None.
    // Postcondition: Prints all BST values from smallest to largest.
    public  void smallToLarge()
    {
        smallToLarge(root);
    }

    // need a helper method as well?

    // Precondition: t is a subtree root (may be null).
    // Postcondition: Prints values in ascending order for subtree rooted at t.
    public  void smallToLarge(TreeNode <E> t)
    {
        if(t == null)
            return;

        smallToLarge(t.getLeft());
        System.out.print(t.getValue());
        smallToLarge(t.getRight());
    }

}  // BinarySearchTree

/* TreeNode class for the AP Exams */

class TreeNode <E>
{
    private E value;
    private TreeNode left, right;

    public TreeNode(E initValue)
    {
        value = initValue;
        left = null;
        right = null;
    }

    public TreeNode(E initValue, TreeNode <E> initLeft, TreeNode <E> initRight)
    {
        value = initValue;
        left = initLeft;
        right = initRight;
    }

    public E getValue()
    {
        return value;
    }

    public TreeNode <E> getLeft()
    {
        return left;
    }

    public TreeNode <E> getRight()
    {
        return right;
    }

    public void setValue(E theNewValue)
    {
        value = theNewValue;
    }

    public void setLeft(TreeNode <E> theNewLeft)
    {
        left = theNewLeft;
    }

    public void setRight(TreeNode <E> theNewRight)
    {
        right = theNewRight;
    }
}