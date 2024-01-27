package Lecture4_StreamAndFiles_Exercise;

import java.io.File;

public class GetFolderSize {
    public static void main(String[] args) {
        String path = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        File directory = new File(path);

        int size = 0;
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();

            for (File file : files) {
                if (!file.isDirectory()) {
                    size += file.length();
                }
            }
        }
        System.out.printf("Folder size: %d%n", size);
    }
}
