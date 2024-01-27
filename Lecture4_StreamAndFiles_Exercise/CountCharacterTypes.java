package Lecture4_StreamAndFiles_Exercise;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String inputPath = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPath = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        Set<Character> punctuations = Set.of('!', ',', '.', '?');

        int vowelsCount = 0;
        int punctuationsCount = 0;
        int othersCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(Path.of(inputPath));
             BufferedWriter writer = Files.newBufferedWriter(Path.of(outputPath))) {
            String line = reader.readLine();
            while (line != null) {
                for (int i = 0; i < line.length(); i++) {
                    char symbol = line.charAt(i);
                    if (vowels.contains(symbol)) {
                        vowelsCount++;
                    } else if (punctuations.contains(symbol)) {
                        punctuationsCount++;
                    } else if (symbol != ' ') {
                        othersCount++;
                    }
                }
                line = reader.readLine();
            }
            writer.write("Vowels: " + vowelsCount);
            writer.newLine();
            writer.write("Other symbols: " + othersCount);
            writer.newLine();
            writer.write("Punctuation: " + punctuationsCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}