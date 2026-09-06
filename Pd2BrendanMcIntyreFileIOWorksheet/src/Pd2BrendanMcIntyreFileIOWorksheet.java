/***
 Name:Brendan McIntyre
 Period:2
 Name of the Program:File Input Exercise

 What I Learned/Reflection:
I got a good refresher on file input from last year.
 ***/
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Pd2BrendanMcIntyreFileIOWorksheet {
    public static void main(String[] args) throws IOException {
        File file = new File("file.txt");
        Scanner input = new Scanner(file);

        int characters = 0;
        int words = 0;
        int lines = 0;
        while(input.hasNextLine()){
            String line = input.nextLine();
            Scanner scan = new Scanner(line);
            while(scan.hasNext()){
                String word = scan.next();
                characters += word.length();
                words++;
            }

            lines++;
        }
        System.out.println("Information about file.txt:");
        System.out.println(characters + " characters\n" + words + " words \n" + lines + " lines");
    }
}
/********* PROGRAM OUTPUTS ******
 Information about file.txt:
 795 characters
 160 words
 20 lines
 **********************************/