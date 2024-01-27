package Lecture4_StreamsAndFiles;

import java.io.*;

public class SerAndDeSer {
    static class Cube implements Serializable {
        String color;
        double width;
        double height;
        double length;

        public Cube(String color, double width, double height, double length) {
            this.color = color;
            this.width = width;
            this.height = height;
            this.length = length;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Cube cube = new Cube("black", 13, 42, 73);
        FileOutputStream outputStream = new FileOutputStream("cube-data.ser");
        ObjectOutputStream objectoutputStream = new ObjectOutputStream(outputStream);

        objectoutputStream.writeObject(cube);
        objectoutputStream.close();

        FileInputStream inputStream = new FileInputStream("cube-data.ser");
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Cube cube2 = (Cube) objectInputStream.readObject();
        System.out.println(cube2.color);
        System.out.println(cube2.height);
        System.out.println(cube2.width);
        System.out.println(cube2.length);
    }
}