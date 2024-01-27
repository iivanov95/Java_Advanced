package Lecture4_StreamAndFiles_Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ALLCAPITALS {
    public static void main(String[] args) {
        String inputPath = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPath = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";


        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {
            String line = reader.readLine();
            while (line != null) {
                writer.write(line.toUpperCase());
                writer.newLine();
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}