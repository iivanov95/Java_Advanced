package Workshop;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        SmartArray smartArray = new SmartArray();

        smartArray.add(13);
        smartArray.add(19);
        smartArray.add(25);
        smartArray.add(48);


        smartArray.remove(2);

        System.out.println();
    }
}