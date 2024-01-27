package Lecture3_SetsAndMapsAdvanced;

import javax.swing.plaf.IconUIResource;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> regular = new TreeSet<>();
        Set<String> vip = new TreeSet<>();

        String guest = scanner.nextLine();
        while (!guest.equals("PARTY")) {
            char startSymbol = guest.charAt(0);
            if (Character.isDigit(startSymbol)) {
                vip.add(guest);

            } else {
                regular.add(guest);

            }
            guest = scanner.nextLine();
        }
        guest = scanner.nextLine();

        while (!guest.equals("END")) {
            vip.remove(guest);
            regular.remove(guest);

            guest = scanner.nextLine();
        }
        System.out.println(vip.size() + regular.size());
        if (!vip.isEmpty()) {
            for (String guests : vip) {
                System.out.println(guests);
            }
        }
        if (!regular.isEmpty()) {
            for (String guests : regular) {
                System.out.println(guests);
            }
        }
    }
}