package Lecture3_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, LinkedHashMap<String, List<String>>>
                countryDataByContinent = new LinkedHashMap<>();

        while (rows-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];

            countryDataByContinent.putIfAbsent(continent, new LinkedHashMap<>());
            LinkedHashMap<String, List<String>>  citiesByCountry = countryDataByContinent.get(continent);

            citiesByCountry.putIfAbsent(country, new ArrayList<>());
            List<String> cities = citiesByCountry.get(country);
            cities.add(city);
        }

        countryDataByContinent.forEach((key, value) -> {
            System.out.println(key + ":");

            value.forEach((country, city) -> {
                String cities = String.join(", ", city);

                System.out.println("  " + country + " -> " + cities);
            });
        });
    }
}