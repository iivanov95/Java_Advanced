package Lecture1_StacksAndQueues;

import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }

    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
