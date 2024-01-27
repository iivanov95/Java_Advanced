package ExamPreparation.easterBasket;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.material = material;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addEgg(Egg egg) {
        if (data.size() >= capacity) {
            throw new RuntimeException ("No capacity!");
        }
        this.data.add(egg);
    }
    public boolean removeEgg(String color) {
        int initialEggCount = data.size();
        this.data = data.stream().filter(egg -> !egg.getColor()
                .equals(color)).collect(Collectors.toList());
        return data.size() != initialEggCount;
    }
    public Egg getStrongestEgg() {
        if (data.isEmpty()) {
            return null;
        }
        var strongestEgg = data.get(0);
        for (Egg egg: data) {
            if (egg.getStrength() > strongestEgg.getStrength()) {
                strongestEgg = egg;
            }
        }
        return strongestEgg;
    }
    public Egg getEgg(String color) {
        var egg = data.stream()
                .filter(e -> e.getColor()
                        .equals(color)).findFirst().orElse(null);
        for (Egg eggg: data) {
            if (eggg.getColor().equals(color)) {
                return eggg;
            }
        }
        return null;
    }
    public int getCount() {
        return data.size();
    }
    public String report() {
        var sj = new StringJoiner("\n");
        sj.add(material + " basket contains:");
        for (Egg egggg: data) {
            sj.add(egggg.toString());
        }
        return sj.toString();
    }
}