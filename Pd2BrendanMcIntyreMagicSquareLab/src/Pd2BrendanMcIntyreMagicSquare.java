/****************************************************
 Name: Brendan McIntyre  Period:2
 Name of the Lab/Assignment: Magic Square Lab

 What I Learned:
I learned how to use 2D arrays in a more complicated program, but also learned what a magic square is.
 ****************************************************/

public class Pd2BrendanMcIntyreMagicSquare {
    public static void main(String[] args) {
        MagicSquare [] testMagicSquares = {
            new MagicSquare(new int[][]{
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
            }),
            new MagicSquare(new int[][]{
                    {16, 3, 2, 13},
                    {5, 10, 11, 8},
                    {9, 6, 7, 12},
                    {4, 15, 14, 1}
            }),
            new MagicSquare(new int[][]{
                    {17, 24, 1, 8, 15},
                    {23, 5, 7, 14, 16},
                    {4, 6, 13, 20, 22},
                    {10, 12, 19, 21, 3},
                    {11, 18, 25, 2, 9}
            }),
            new MagicSquare(new int[][]{
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            }),
            new MagicSquare(new int [][]{
                    {8, 8, 8},
                    {8, 8, 8},
                    {8, 8, 8}

            })};

        for (MagicSquare magicSquare : testMagicSquares) {
            System.out.println(magicSquare.isMagic());
        }
    }//main
}//Pd2BrendanMcIntyreMagicSquare

class MagicSquare {
    private int [][] square;

    public MagicSquare(int[][] square) {
        this.square = square;
    }

    //0 < row < square.length
    // returns the row sum indicated by row
    public int rowSum (int row){
        int  sum = 0;
        for (int  c = 0; c < square[row].length; c++)
            sum += square[row][c];
        return sum;
    }//rowSum

    //0 < col < square.length
    // returns the column sum indicated by col
    public int colSum (int col){
        int  sum = 0;
        for (int  r = 0; r < square.length; r++)
            sum += square[r][col];
        return sum;
    }//colSum

    // none
    // returns whether both the major and minor diagonal sums are equal to sum.
    public boolean diagSums (int sum){
        int sumL = 0;
        int sumR = 0;
        int  dim = square.length;
        for (int k = 0; k < square.length; k++) sumL += square[k][k];
        for (int i = 0; i < square.length; i++)
            sumR += square [i] [dim-1-i];
        return sumR == sumL && sumR == sum;

    }//diagSums

    //none
    //returns if every number exists exactly once in square.
    public boolean exactlyOne(){
        boolean [] foundNums = new boolean[square.length * square.length + 1];
        for(int [] row : square){
            for (int num : row){
                if(foundNums[num]) return false;
                foundNums[num] = true;
            }
        }
        return true;
    }//exactlyOne

    //none
    //returns if square is a magic square.
    public boolean isMagic (){
        int totalNum = rowSum(0);
        for (int i = 0; i < square.length; i++){
            if (rowSum(i) != totalNum || colSum(i) != totalNum)
                return false;
        }
        return diagSums(totalNum) && exactlyOne();
    }//isMagic

}//MagicSquare