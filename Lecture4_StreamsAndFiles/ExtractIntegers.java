package Lecture4_StreamsAndFiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "src/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        Scanner scanner = new Scanner(new FileInputStream(path));

        PrintWriter printWriter = new PrintWriter(new FileOutputStream("extract-integers-output.txt"));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printWriter.println(scanner.next());
            }
            scanner.next();
        }
        printWriter.close();
    }
}