import java.util.LinkedList;
import java.util.Queue;

/**
 * Name:Brendan McIntyre                             Period: 2
 *
 * Date Submitted: 2/17/26
 *
 * Purpose of the Program: The purpose of this is to get a better understanding of how to access data in a tree data set.

 * What I learned: I learned how to display the tree level-by-level and what display the tree sideways is.
 *
 * What I found most challegning in this lab: I didn't initially realize why the output didn't match the intended output.
 *
 * How I overcame the challenge(s) and what strategies I used:
 *  I read over all the code and found that I needed to uncomment some code and an i-value was set to 2 instead of 1.
 */

public class Pd2BrendanMcIntyreTreeLab
{
    public static void main(String[] args)
    {
        String s = "XCOMPUTERSCIENCE";

        TreeNode <String>  root = new TreeNode <> ("" + s.charAt(1), null, null);

        for(int index = 1; index < s.length(); index++) //I changed it so that the output would work by changing i from 2 to 1.
            insert(root, "" + s.charAt(index), index, (int)(1 + Math.log(index) / Math.log(2)));

        // NOTE: The following 3 lines are supposed to show you how insert works. You
        //             uncomment them and see how the tree looks like with these 3 additional nodes
        insert(root, "A", 17, 5);
        insert(root, "B", 18, 5);
        insert(root, "C", 37, 6); //B's right child

        // display the tree sideway; see the sample output at the end of this file
        display(root, 0);

        System.out.print("\nPreorder: ");
        preorderTraverse(root);

        System.out.print("\nInorder: ");
        inorderTraverse(root);

        System.out.print("\nPostorder: ");
        postorderTraverse(root);

        System.out.println("\n\nNodes = " + countNodes(root));
        System.out.println("Leaves = " + countLeaves(root));
        System.out.println("Grandparents = " + countGrandParentNodes(root));  // count the number grandparent nodes
        System.out.println("Only childs = " + countSingleChildNodes(root));   // count the number of nodes that has only 1 child

        //System.out.println("\nDepth = " + numOfLevels(root));
        System.out.println("Height = " + height(root));

        System.out.println("Min = " + min(root));
        System.out.println("Max = " + max(root));

        // level by level display of the nodes (starts from left to right for nodes on the same level)
        System.out.println("\nLevel-by-level display of the tree: ");
        displayLevelOrder(root);

    } // end of main


    // insert a new node in the tree based on the node's level
    public static void insert(TreeNode t, String s, int pos, int level)
    {
        TreeNode p = t;
        for(int k = level - 2; k > 0; k--)
            if((pos & (1 << k)) == 0)
                p = p.getLeft();      // What does this do? Answer this question first.  What does '&' do?
            else                     // Google it!!!!  We did not learn this in APCS A!  : It only checks the first condition if the first condition is false because it will be false anyway.
                p = p.getRight();     // What does this do? Answer this question first.

        if((pos & 1) == 0)
            p.setLeft(new TreeNode(s, null, null));
        else
            p.setRight(new TreeNode(s, null, null));
    } // end of insert


    /*****************************************************************************************************
     postcondition: display the tree sideway
     *****************************************************************************************************/
    public static void display(TreeNode t, int level)
    {
        if(t == null)
            return;

        display(t.getRight(), level + 1);
        System.out.println(t.getValue());
        display(t.getLeft(), level + 1);
    } // end of display

    public static void preorderTraverse(TreeNode  t)
    {
        if(t != null) {
            System.out.print(t.getValue());
            preorderTraverse(t.getLeft());
            preorderTraverse(t.getRight());
        }
    }

    public static void inorderTraverse(TreeNode t)
    {
        if(t != null) {
            inorderTraverse(t.getLeft());
            System.out.print(t.getValue());
            inorderTraverse(t.getRight());
        }
    }


    public static void postorderTraverse(TreeNode  t)
    {
        if(t != null) {
            postorderTraverse(t.getLeft());
            postorderTraverse(t.getRight());
            System.out.print(t.getValue());
        }
    }

    public static int countNodes(TreeNode  t)
    {
        int count = 0;
        if(t != null) {
            count += countNodes(t.getLeft());
            count += countNodes(t.getRight());
            count++;
        }
        return count;
    }

    public static int countLeaves(TreeNode t)
    {
        if(t == null)
            return 0;

        if(t.getLeft() == null && t.getRight() == null)
            return 1;

        return countLeaves(t.getLeft()) + countLeaves(t.getRight());
    }


    // Hint: Use the height method to help you
    public static int countGrandParentNodes(TreeNode t)
    {
        if(t == null) {
            return 0;
        }
        int count = 0;

        if(height(t) >= 2)
            count++;

        return count + countGrandParentNodes(t.getLeft()) + countGrandParentNodes(t.getRight());
    }



    public static int countSingleChildNodes(TreeNode t)
    {
        if(t == null) {
            return 0;
        }
        int count = 0;

        if((t.getLeft() == null && t.getRight() != null) || (t.getLeft() != null && t.getRight() == null)) {
            count++;
        }
        return count + countSingleChildNodes(t.getLeft()) + countSingleChildNodes(t.getRight());
    }



    public static int height(TreeNode t)
    {
        if(t == null)
            return -1;

        return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
    }

    public static Object min(TreeNode t)
    {
        if(t == null)
            return null;

        String smallest = (String)t.getValue();

        if(t.getLeft() != null)
        {
            String leftMin = (String)min(t.getLeft());
            if(leftMin.compareTo(smallest) < 0) {
                smallest = leftMin;
            }
        }

        if(t.getRight() != null)
        {
            String rightMin = (String)min(t.getRight());
            if(rightMin.compareTo(smallest) < 0) {
                smallest = rightMin;
            }
        }
        return smallest;
    }


    public static Object max(TreeNode t)
    {
        if(t == null){
            return null;
        }

        String biggest = (String)t.getValue();

        if(t.getLeft() != null){
            String leftMax = (String)max(t.getLeft());
            if(leftMax.compareTo(biggest) > 0) {
                biggest = leftMax;
            }
        }

        if(t.getRight() != null){
            String rightMax = (String)max(t.getRight());
            if(rightMax.compareTo(biggest) > 0){
                biggest = rightMax;
            }
        }

        return biggest;
    }


    /*****************************************************************************************************
     This method is not recursive.
     Hint: Use a local queue to store the children of the current node.
     *****************************************************************************************************/
    public static void displayLevelOrder(TreeNode t)
    {
        if(t == null)
            return;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(t);

        while(!q.isEmpty())
        {
            TreeNode current = q.remove();
            System.out.print(current.getValue());

            if(current.getLeft() != null)
                q.add(current.getLeft());

            if(current.getRight() != null)
                q.add(current.getRight());
        }
    }

}  // end of TreeLab_shell



class TreeNode<E>
{
    private E value;
    private TreeNode<E> left, right;

    public TreeNode(E initValue)
    {
        value = initValue;
        left = null;
        right = null;
    }

    public TreeNode(E initValue, TreeNode initLeft, TreeNode initRight)
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

    public TreeNode<E> getRight()
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


/***************************************************

 ----jGRASP exec: java Lab01

 E
 E
 C
 M
 N
 T
 E
 C
 I
 U
 C
 O
 S
 C
 B
 P
 A
 R

 Preorder: C O P R A S B C U C I M T E N E C E
 Inorder: R A P B C S O C U I C E T N M C E E
 Postorder: A R C B S P C I U O E N T C E E M C

 Nodes = 18
 Leaves = 8
 Grandparents = 5
 Only childs = 3

 Height = 5
 Min = A
 Max = U

 Level-by-level:
 COMPUTERSCIENCEABC

 *******************************************************/