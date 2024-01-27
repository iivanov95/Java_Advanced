package ExamPreparation;

import java.util.*;

public class ClimbThePeaks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] portions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] stamina = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> portionsStack = new ArrayDeque<>();
        Deque<Integer> staminaQueue = new ArrayDeque<>();

        Map<String, Integer> peaksToClimb = new LinkedHashMap<>();
        peaksToClimb.put("Vihren", 80);
        peaksToClimb.put("Kutelo", 90);
        peaksToClimb.put("Banski Suhodol", 100);
        peaksToClimb.put("Polezhan", 60);
        peaksToClimb.put("Kamenitza", 70);



        Deque<String> peaksQueue = new ArrayDeque<>(Arrays.asList("Vihren",
                                                                "Kutelo",
                                                                "Banski Suhodol",
                                                                "Polezhan",
                                                                "Kamenitza"));

        for (int i = 0; i < portions.length; i++) {
            portionsStack.push(portions[i]);
        }
        for (int i = 0; i < stamina.length; i++) {
            staminaQueue.offer(stamina[i]);
        }
        List<String> peaksClimbed = new LinkedList<>();
        while (!portionsStack.isEmpty() && !staminaQueue.isEmpty() && !peaksToClimb.isEmpty()) {
            Integer currentStamina = staminaQueue.poll();
            Integer currentPortion = portionsStack.pop();
            int sum = currentStamina + currentPortion;
            String currentPeak = peaksQueue.peek();
            if (sum >= peaksToClimb.get(currentPeak)) {
                peaksQueue.poll();
                peaksToClimb.remove(currentPeak);
                peaksClimbed.add(currentPeak);
            }
        }
        if (peaksToClimb.isEmpty()) {
            System.out.println("Alex did it! He climbed all top five Pirin peaks in one week -> @FIVEinAWEEK");
        } else {
            System.out.println("Alex failed! He has to organize his journey better next time -> @PIRINWINS");
        }
        if (!peaksClimbed.isEmpty()) {
            System.out.println("Conquered peaks:");
            peaksClimbed.forEach(System.out::println);
        }
    }
}