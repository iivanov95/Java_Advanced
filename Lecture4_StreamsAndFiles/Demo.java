package Lecture4_StreamsAndFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = scanner.nextLine();
        try {
            FileInputStream inputStream = new FileInputStream(path);
            int oneByte = inputStream.read();
            System.out.println(oneByte);
        } catch (IOException e) {
            System.out.println("File with path " + path + " was not found!");
        }

    }
}