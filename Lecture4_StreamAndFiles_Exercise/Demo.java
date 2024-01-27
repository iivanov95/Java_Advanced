package Lecture4_StreamAndFiles_Exercise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Demo {
    public static void main(String[] args) {
        String path = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        try (FileInputStream fileInputStream = new FileInputStream(path)) {
            int oneByte = fileInputStream.read();
            while (oneByte != -1) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileInputStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("===========================================");
        try (FileReader fileReader = new FileReader(path)) {
            int asciiCOde = fileReader.read();
            while (asciiCOde != -1) {
                char symbol = (char) asciiCOde;
                System.out.print(symbol);
                asciiCOde = fileReader.read();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}