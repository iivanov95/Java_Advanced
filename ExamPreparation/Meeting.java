package ExamPreparation;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] males = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] females = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> malesStack = new ArrayDeque<>();
        Deque<Integer> femalesQueue = new ArrayDeque<>();

        for (int male : males) {
            malesStack.push(male);
        }
        for (int female : females) {
            femalesQueue.offer(female);
        }

        int numMatches = 0;
        while (!malesStack.isEmpty() && !femalesQueue.isEmpty()) {
            int currentFemale = femalesQueue.peek();
            int currentMale = malesStack.peek();
            if (currentFemale <= 0) {
                femalesQueue.poll();
                continue;
            }
            if (currentMale <= 0) {
                malesStack.pop();
                continue;
            }
            if (currentFemale % 25 == 0 && currentMale % 25 == 0) {
                femalesQueue.poll();
                femalesQueue.poll();
                malesStack.pop();
                malesStack.pop();
                continue;
            } else {
                if (currentFemale % 25 == 0) {
                    femalesQueue.poll();
                    femalesQueue.poll();
                    continue;
                }
                if (currentMale % 25 == 0) {
                    malesStack.pop();
                    malesStack.pop();
                    continue;
                }
            }
            if (currentFemale == currentMale) {
                femalesQueue.poll();
                malesStack.pop();
                numMatches++;
            } else {
                femalesQueue.poll();
                malesStack.pop();
                currentMale -= 2;
                if (currentMale > 0) {
                    malesStack.push(currentMale);
                }
            }
        }
        System.out.println("Matches: " + numMatches);
        if (!malesStack.isEmpty()) {
            String result = String.join(", ", malesStack.toString().replace("[", "").replace("]", ""));
            System.out.println("Males left: " + result);
        } else {
            System.out.println("Males left: none");
        }
        if (!femalesQueue.isEmpty()) {
            String result = String.join(", ", femalesQueue.toString().replace("[", "").replace("]", ""));
            System.out.println("Females left: " + result);
        } else {
            System.out.println("Females left: none");
        }
    }
}