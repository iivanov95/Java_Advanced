package Lecture4_StreamAndFiles_Exercise;

import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {

        Course course = new Course("Java Advance", 250);

        String path = "src/Lecture4_StreamAndFiles_Exercise/04. Java-Advanced-Files-and-Streams-Exercises-Resources/course.ser";

        try (FileOutputStream fileOutputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
             FileInputStream fileInputStream = new FileInputStream(path);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            //serialization
            objectOutputStream.writeObject(course);
            //deserialization
            Object object = (Course) objectInputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}