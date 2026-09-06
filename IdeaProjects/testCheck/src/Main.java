public class Main {
    public static void main(String[] args) {
        double dollarBillAmount = 5;
        double costOfItem = 2.25;
        double change = dollarBillAmount - costOfItem;
        int bills = (int)change;
        int quarters = (int)((change-bills)*100)/25;
        System.out.print("Change: "+bills+" dollars and "+ quarters+" quarters");
    }
}