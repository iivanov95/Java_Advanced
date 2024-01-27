package Lecture7_Generics;

public class MainScale {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("a", "b");
        Scale<Integer> scale2 = new Scale<>(13, 42);
        System.out.println(scale2.getHeavier());
        System.out.println(scale.getHeavier());
    }
}
