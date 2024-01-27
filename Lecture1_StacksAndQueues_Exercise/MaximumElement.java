package Lecture1_StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            switch (input[0]) {
                case "1":
                    int element = Integer.parseInt(input[1]);
                    stack.push(element);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}