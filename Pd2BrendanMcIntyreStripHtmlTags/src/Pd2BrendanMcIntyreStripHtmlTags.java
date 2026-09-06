/****************************************************
 Name: Brendan McIntyre  Period:2
 Name of the Lab/Assignment: Exercise 6.10
 ****************************************************/
import java.io.*;
import java.util.*;

class Pd2BrendanMcIntyreStripHtmlTags {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("htmlCode.txt"));
        stripHtmlTags(input);
    }

     //Preconditions:
     //input is a valid Scanner object connected to a readable text file.
     //The file contains lines of text, possibly with HTML tags.
     //HTML tags do not span across multiple lines.
     //Post conditions:
     //All HTML tags in each line are removed.
     //Plain text (with tags stripped) is printed to the console.
    public static void stripHtmlTags(Scanner input) {
        while (input.hasNextLine()) {
            String text = input.nextLine();
            process(text);
        }
    }

     //Preconditions:
     //text is a non-null String.
     //Tags are well-formed (each '<' has a corresponding '>').
     //No tags span multiple lines or are malformed.
     //Post conditions:
     //All substrings between < and > are removed from the text.
     //Resulting plain text is printed to the console.
    public static void process(String text) {
        while (text.contains("<")) {
            text = text.substring(0, text.indexOf("<")) + text.substring(text.indexOf(">") + 1);
        }
        System.out.println(text);
    }
}
