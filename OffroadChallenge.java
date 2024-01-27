import java.util.*;

public class OffroadChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] thirdLine = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> initialFuelStack = new ArrayDeque<>();
        Deque<Integer> consumptionIndexQueue = new ArrayDeque<>();
        Deque<Integer> amountOfFuelNeededQueue = new ArrayDeque<>();

        for (Integer fuel : firstLine) {
            initialFuelStack.push(fuel);
        }
        for (Integer item : secondLine) {
            consumptionIndexQueue.offer(item);
        }
        for (Integer item : thirdLine) {
            amountOfFuelNeededQueue.offer(item);
        }
        boolean isReached = true;
        List<String> altitudesReached = new ArrayList<>();
        int altitude = 0;
        while (isReached && !amountOfFuelNeededQueue.isEmpty()) {
            altitude++;
            int currentConsumptionIndex = consumptionIndexQueue.peek();
            int currentFuelNeeded = amountOfFuelNeededQueue.peek();
            int currentFuel = initialFuelStack.peek();
            int result = currentFuel - currentConsumptionIndex;
            String currentAltitude = "Altitude " + altitude;
            if (result >= currentFuelNeeded) {
                consumptionIndexQueue.poll();
                amountOfFuelNeededQueue.poll();
                initialFuelStack.pop();
                altitudesReached.add(currentAltitude);
                System.out.printf("John has reached: %s%n", currentAltitude);
            } else {
                System.out.printf("John did not reach: %s%n", currentAltitude);
                isReached = false;
            }
        }
        if (amountOfFuelNeededQueue.isEmpty()) {
            System.out.println("John has reached all the altitudes and managed to reach the top!");
        } else {
            if (altitudesReached.isEmpty()) {
                System.out.println("John failed to reach the top.");
                System.out.println("John didn't reach any altitude.");
            } else {
                System.out.println("John failed to reach the top.");
                String result = "";
                for (String item : altitudesReached) {
                    result = String.join(", ", altitudesReached.toString().replace("[", "").replace("]", ""));
                }
                System.out.println("Reached altitudes: " + result);
            }
        }
    }
}