/****************************************************
 Name: Brendan McIntyre  Period:2
 Name of the Lab/Assignment: Order Matters Lab

 What I Learned: I learned how to customize the spacing for a table based on the values in it.
 ****************************************************/
class Main {
    public static void main(String args[]){
        int r, c;
        double [] arr= {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0, 11.0,
                12.0};

        r = 3;
        c = 4;
        System.out.println("rows = " + r + "\t columns = " + c);

        System.out.println("***Checking the constructor");
        Pd2BrendanMcIntyreOrderMatters ob1 = new Pd2BrendanMcIntyreOrderMatters(r, c);
        ob1.print2D();

        System.out.println("\n***rowOrder");
        ob1.rowOrder(arr);
        ob1.print2D();

        System.out.println("\n***columnOrder");
        ob1.columnOrder(arr);
        ob1.print2D();

        System.out.println("\n***wrappedOrder");
        ob1.wrappedOrder(arr);
        ob1.print2D();
    }
}

public class Pd2BrendanMcIntyreOrderMatters{
    private double [][] orderedData;
    private int rows;
    private int cols;

    // Precondition: numberOfRows and numberOfColumns are positive integers.
    // Postcondition: orderedData is a 2D array of size rows x cols, initialized to default values (0.0).
    public Pd2BrendanMcIntyreOrderMatters(int numberOfRows, int numberOfColumns){
        rows = numberOfRows;
        cols = numberOfColumns;
        orderedData = new double [rows][cols];
    }

    // Precondition: arr contains at least rows * cols elements.
    // Postcondition: orderedData is filled with elements of arr, row-wise.
    public void rowOrder(double [] arr){
        int index = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                orderedData[r][c] = arr[index];
                index++;
            }
        }
    }

    // Precondition: arr contains at least rows * cols elements.
    // Postcondition: orderedData is filled with elements of arr, column-wise.
    public void columnOrder(double [] arr){
        int index = 0;
        for(int r = 0; r < cols; r++){
            for(int c = 0; c < rows; c++){
                orderedData[c][r] = arr[index];
                index++;
            }
        }
    }

    // Precondition: arr contains at least rows * cols elements.
    // Postcondition: orderedData is filled with elements of arr in a wrapped order.
    public void wrappedOrder(double [] arr){
        boolean reverse = false;
        int index = 0;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if (reverse){
                    orderedData[r][cols - c - 1] = arr[index];
                }
                else {
                    orderedData[r][c] = arr[index];
                }
                index++;
            }
            reverse = !reverse;
        }
    }

    // Precondition: orderedData is already filled with some data (either by rowOrder, columnOrder, or wrappedOrder).
    // Postcondition: The 2D array is printed with proper row and column labels.
    public void print2D(){
        System.out.print("\t\t\t");
        for(int i = 0; i < cols; i++){
            System.out.print("cols " + i + "  ");
        }
        System.out.println();
        for(int r = 0; r < rows; r++){
            System.out.print("row " + r + "\t\t");
            for(int c = 0; c < cols; c++){
                String data = "" + orderedData[r][c];
                System.out.print(data);
                for(int i = 8 - data.length(); i > 0; i--){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}