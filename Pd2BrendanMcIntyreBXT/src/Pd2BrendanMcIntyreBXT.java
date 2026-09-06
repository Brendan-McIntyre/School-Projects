/*****************************************************************************************************************
 NAME: Brendan McIntyre
 PERIOD: 2
 DUE DATE:3/9/26

 PURPOSE: The purpose was to full grasp BXT trees by making methods to create, extract data, and
          manipulate the tree.

 WHAT I LEARNED: I learned how to create the BXT tree not just know how to manipulate it and
                 I also learned how to turn a string into a double from geeksforgeeks.org.

 CREDITS (BE SPECIFIC: FRIENDS, PEERS, ONLINE WEBSITES, ETC.): geeksforgeeks.org

 ****************************************************************************************************************/
import java.util.*;

/***********************************
 Represents a binary expression tree.
 The BXT can build itself from a postorder expression.  It can
 evaluate and print itself. It also prints an inorder string and a preorder string.
 ************************************/

/*******************
 Driver for a binary expression tree class.
 Input: a postfix string, each token separated by a space.
 **********************/
public class Pd2BrendanMcIntyreBXT
{
    public static void main(String[] args)
    {
        BXT tree = new BXT();
        Scanner sc = new Scanner(System.in);
        System.out.print("Input postfix string: ");
        // Try these 3 postfix expressions:
        // 14 -5 /
        // 3 4 5 + *
        // 2 3 + 5 / 4 5 - *

        String s =  sc.nextLine();
        tree.buildTree(s);
        tree.display();
        System.out.print("Infix order:  ");
        tree.inorderTraverse();
        System.out.print("\nPrefix order:  ");
        tree.preorderTraverse();
        System.out.print("\nEvaluates to " + tree.evaluateTree());
    }
}  // BXT_shell


class BXT <E extends Comparable <E>>
{

    private TreeNode <E> root;

    // Precondition: None.
    // Postcondition: Initializes an empty binary expression tree.
    public BXT()
    {
        root = null;
    }

    // Precondition: obj is a valid value of type E.
    // Postcondition: Initializes a binary expression tree with root node containing obj.
    public BXT(E obj)
    {
        root = new TreeNode <>(obj, null, null);
    }

    /***********************
     Builds a BXT from a postfix expression.
     Uses a helper stack of TreeNodes.
     ****************************/

    // Precondition: str is a valid postfix expression with numbers and operators separated correctly.
    // Postcondition: Builds a binary expression tree representing the postfix expression.
    public void buildTree(String str)
    {
        Stack<TreeNode> trees = new Stack<>();
        char node;
        String s;
        TreeNode right;
        TreeNode left;
        for(int i = 0; i < str.length(); i++){
            s = str.substring(i, i+1);
            if(isOperator(s)) {
                right = trees.pop();
                left = trees.pop();
                trees.push(new TreeNode<>(s, left, right));
            }
            else
                trees.push(new TreeNode<>((E)Double.valueOf(s)));
        }
        root = trees.pop();
    }

    // Precondition: Tree has been built (root may not be null).
    // Postcondition: Evaluates the binary expression tree and returns the numeric result.
    public double evaluateTree()
    {
        return evaluateNode(root);
    }

    // Precondition: t is a node in the binary expression tree (may be null).
    // Postcondition: Recursively evaluates the subtree rooted at t and returns its value.
    private double evaluateNode(TreeNode <E> root)
    {
        if(root == null)
            return 0.0;

        if(root.getLeft() != null && root.getRight() != null) {
            return computeTerm((String)root.getValue(), evaluateNode(root.getLeft()), evaluateNode(root.getRight()));
        }
        return (Double)root.getValue();
    }

    // Precondition: s is one of "+", "-", "*", "/", "%".
    // Postcondition: Computes a single operation a (operator) b and returns the result.
    private double computeTerm(String s, double a, double b)
    {
        if(s.equals("+"))
            return a+b;
        else if(s.equals("-"))
            return a-b;
        else if(s.equals("*"))
            return a*b;
        else if(s.equals("/"))
            return a/b;
        else
            return a%b;
    }

    // Precondition: s is a string.
    // Postcondition: Returns true if s is an operator, false otherwise.
    private boolean isOperator(String s)
    {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("%");
    }

    // Precondition: Tree may be empty or non-empty.
    // Postcondition: Displays the tree sideways with right subtree above left subtree.
    public void display()
    {
        display(root, 0);
    }

    // Precondition: root is a node of the tree (it may be null); level >= 0.
    // Postcondition: Recursively prints the subtree rooted at root sideways with indentation by level.
    private void display(TreeNode <E> root, int level)
    {
        if(root == null)
            return;
        display(root.getRight(), level + 1); //recurse right
        for(int k = 0; k < level; k++)
            System.out.print("\t");
        System.out.println(root.getValue());
        display(root.getLeft(), level + 1); //recurse left
    }

    //display() from TreeLab01
    // Precondition: Tree may be empty or non-empty.
    // Postcondition: Prints all values of the tree in inorder traversal.
    public void inorderTraverse()
    {
        inorderTraverse(root);
    }

    // Precondition: t is a node in the tree ( it may be null).
    // Postcondition: Recursively prints values in the subtree rooted at t in inorder.
    public void inorderTraverse(TreeNode<E> t){
        if(t != null){
            inorderTraverse(t.getLeft());
            System.out.print(t.getValue());
            inorderTraverse(t.getRight());
        }
    }

    // Precondition: Tree may be empty or non-empty.
    // Postcondition: Prints all values of the tree in preorder traversal.
    public void preorderTraverse()
    {
        preorderTraverse(root);
    }

    // Precondition: t is a node in the tree (it may be null).
    // Postcondition: Recursively prints values in the subtree rooted at t in preorder.
    public void preorderTraverse(TreeNode<E> t){
        if(t != null){
            System.out.print(t.getValue());
            preorderTraverse(t.getLeft());
            preorderTraverse(t.getRight());
        }
    }
}  // BXT

class TreeNode <E>
{
    private E value;
    private TreeNode <E> left, right;

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