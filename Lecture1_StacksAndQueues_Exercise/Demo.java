package Lecture1_StacksAndQueues_Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        stack.push(12);
        stack.push(25);
        stack.push(65);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("Now the queue:");
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.offer(12);
        queue.offer(25);
        queue.offer(65);
        queue.offer(4);
        queue.offer(5);
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}