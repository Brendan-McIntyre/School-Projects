import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner name = new Scanner(System.in);

        System.out.println("What is your first name?");
        String firstName = name.next();
        System.out.println(firstName);

        System.out.println("What is your age?");
        int age = name.nextInt();
        System.out.println(age);

        System.out.println("What is your senior quote?");
        String quote = name.next();
        quote += name.nextLine();
        System.out.print(quote);
    }
}