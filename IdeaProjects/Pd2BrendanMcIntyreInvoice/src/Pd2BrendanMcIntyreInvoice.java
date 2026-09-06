/****************************************************
 Name (Full Name): Brendan McIntyre  Period: 2
 Name of the Lab/Assignment:  U2 Review worksheet 2, problem 3
 Purpose: Imput an item and it's price and whether of not you want overnight shipping
then it will out put the Invoice.
 ****************************************************/
import java.text.DecimalFormat;
import java.util.Scanner;
public class Pd2BrendanMcIntyreInvoice {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        //Asking user the name of the item
        System.out.println("Enter the item:");
        String item = keyboard.nextLine();

        //Asking user the price of their item
        System.out.println("Enter the price");
        double price = keyboard.nextDouble();

        //Asking user if they want overnight delivery
        System.out.println("Overnight delivery (0 == no, 1 == yes)");
        int shippingMethod = keyboard.nextInt();

        //calling printInvoice
        printInvoice(item, price, shippingMethod);
    }

    /*
    Precondition:
        item - sting
        price - positive double
        shippingMethod - 0 or 1
    Postcondition:
        Return Type - void
        Purpose - prints item price, shipppingCost and calculations for total cost of order
    **/
    public static void printInvoice (String item, double price, int shippingMethod)
    {
        DecimalFormat df = new DecimalFormat("#0.00");
        double shippingCost;

        if (price < 10){//item less than $10
            shippingCost = 2.00;
        }


        else{//item more than $10
            shippingCost = 3.00;
        }

        if (shippingMethod == 1) {//wants overnight delivery
            shippingCost += 5;
        }

        System.out.println("Invoice: \n \t"+ item + " " + df.format(price));
        System.out.println("\tshipping " + df.format(shippingCost));
        System.out.print("\ttotal " + df.format((price+shippingCost)));
    }//Invoice
    /********* PROGRAM OUTPUTS ******
     Invoice:
     item price
     shipping shippingCost
     total (price+shippingCost)

     Invoice:
     Sandwich 0.00
     shipping 7.00
     total 7.00

     Invoice:
     burito 700000.00
     shipping 8.00
     total 700008.00

     Invoice:
     hotdog 3.00
     shipping 3.00
     total 6.00
     **********************************/
} //end of Pd2BrendanMcIntyreInvoice