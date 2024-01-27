package Lecture1_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String previousURL = "no previous URLs";
        ArrayDeque<String> history = new ArrayDeque<>();
        history.push(previousURL);
        while (!line.equals("home")) {

            if (line.equals("back")) {
                if (history.size() == 1) {
                    System.out.println(history.peek());
                } else {
                    previousURL = history.pop();
                    System.out.println(previousURL);
                }
                System.out.println(previousURL);
            } else {
                if (!"no previous URLs".equals(previousURL)) {
                    history.push(previousURL);
                }
                previousURL = line;
                System.out.println(line);
            }
            line = scanner.nextLine();
        }
    }
}