package Lecture4_StreamAndFiles_Exercise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class CreateZipArchive {
    public static void main(String[] args) {
        String inputPath1 = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String inputPath2 = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String inputPath3 = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";
        String outputPath = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/files.zip";

        List<String> paths = List.of(inputPath1, inputPath2, inputPath3);

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
            ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream)) {
            for (String path : paths) {
                File fileToZip = new File(path);

                FileInputStream fileInputStream = new FileInputStream(fileToZip);
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());

                zipOutputStream.putNextEntry(zipEntry);
                int read = fileInputStream.read();
                while (read != -1) {
                    zipOutputStream.write(read);

                    read = fileInputStream.read();
                }
                fileInputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}