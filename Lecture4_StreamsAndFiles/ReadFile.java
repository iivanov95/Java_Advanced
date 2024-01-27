package Lecture4_StreamsAndFiles;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {

        String path = "src/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        int oneByte = inputStream.read();

        while (oneByte >= 0) {
            System.out.print(Integer.toBinaryString(oneByte) + " ");
            oneByte = inputStream.read();
        }
    }
}