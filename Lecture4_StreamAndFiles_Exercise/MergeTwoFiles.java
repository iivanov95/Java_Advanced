package Lecture4_StreamAndFiles_Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MergeTwoFiles {
    public static void main(String[] args) {
        String inputPath1 = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String inputPath2 = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String outputPath = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";


        try (BufferedReader reader1 = Files.newBufferedReader(Path.of(inputPath1));
             BufferedReader reader2 = Files.newBufferedReader(Path.of(inputPath2));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {

            String line1 = reader1.readLine();
            while (line1 != null) {
               writer.write(line1);
               writer.newLine();
               line1 = reader1.readLine();
            }
            String line2 = reader2.readLine();
            while (line2 != null) {
                writer.write(line2);
                writer.newLine();
                line2 = reader2.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}