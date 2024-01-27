package Lecture6_DefiningClasses.CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String brand = tokens[0];
            Car car;
            if (tokens.length == 1) {
               car = new Car(tokens[0]);
            } else {
                String model = tokens[1];
                int hp = Integer.parseInt(tokens[2]);
                car = new Car(brand, model, hp);
            }
            cars.add(car);
        }
        cars.forEach(System.out::println);
    }
}