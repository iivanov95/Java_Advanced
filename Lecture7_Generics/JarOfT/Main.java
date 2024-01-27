package Lecture7_Generics.JarOfT;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Jar<Integer> nums = new Jar<>();

        nums.add(69);
        nums.add(42);
        nums.remove(42);

    }
}
