package Lecture4_StreamsAndFiles;

import java.io.File;
import java.util.ArrayDeque;

public class BreathFirstSearch {
    public static void main(String[] args) {

        String path = "src/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        ArrayDeque<File> queue = new ArrayDeque<>();

        queue.offer(new File(path));
        int count = 0;
        while (!queue.isEmpty()) {

            File f = queue.poll();
            count++;
            File[] files = f.listFiles();
            if (files != null) {
                for (File file : files) {
                    queue.offer(file);
                }
            }
        }
        System.out.println(count);
    }
}