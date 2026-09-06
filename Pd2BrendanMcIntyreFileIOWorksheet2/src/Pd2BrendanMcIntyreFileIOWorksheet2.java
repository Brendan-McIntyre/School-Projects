/***
 Name:Brendan McIntyre
 Period:2
 Name of the Program:Writing to a file

 What I Learned/Reflection:
 I learn what Printstream is and how to use it.
 ***/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Pd2BrendanMcIntyreFileIOWorksheet2{
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("NextLineBraceStyleTest.txt"));
        Scanner input = new Scanner(new File("Test.java"));
        out.print(input.nextLine());
        while(input.hasNextLine()){
            String line = input.nextLine();
            if(line.indexOf("{") >= 0){
                out.print(" {");
            }
            else{
                out.println();
                out.print(line);
            }
        }
    }
}
//Output in NextLineBraceStyleTest.txt