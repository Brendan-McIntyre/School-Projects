/****************************************************

 Name (Full Name): Brendan McIntyre   Period: 2
        Name of the Lab/Assignment: U5: Account classwork lab
        Purpose: Maintain Bank Account

 How I feel about this programming experience:
    This was the easier one of the 2 programs we were assigned so it helped me with the basics.
    This program was very helpful to grasp the concepts in Unit 5.


 What I Learned:
    It helped me solidify my understanding of the classes and how to implement them.

 ****************************************************/

import java.text.DecimalFormat;

public class Pd2BrendanMcIntyreAccountDriver {
    public static void main(String[] args) {
        Account myBank = new Account(5);
        myBank.deposit(50);
        System.out.print(myBank.toString());
    }//main
}//Pd2BrendanMcIntyreAccountDriver

class Account {
    private double balence;//double with the value of bank balance

    //Pre-condition: No parameters
    //Post-condition: Sets balance to 0.0
    public Account() {//default constructor
        balence = 0.0;
    }
    //Pre-condition: bal is double
    //Post-condition: Sets the initial value of balance to bal value
    public Account(double bal){//overload constructor
        balence = bal;
    }
    //Pre-condition: No parameters
    //Post-condition: Returns the balance
    public double checkBalence() {// returns balence at that point
        return balence;
    }
    //Pre-condition: add is double
    //Post-condition: adds the double add from balance
    public void deposit (double add) {//adds double to balance
        balence += add;
    }
    //Pre-condition: subtract is double
    //Post-condition: subtracts the double subtract from balance
    public void withdraw (double subtract) {// subtracts
        balence -= subtract;
    }
    //Pre-condition: No parameters
    //Post-condition: Returns the balance with a dollar sign in front of it.
    public String toString (){
        DecimalFormat df = new DecimalFormat("#0.00");
        return "$" + df.format(balence);
    }

}//Account
/********* PROGRAM OUTPUTS ******
 $55.00
 $50.00
 $0.00
 **********************************/