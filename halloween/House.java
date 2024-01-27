package halloween;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class House {
    private int capacity;
    private List<Kid> data;

    public House(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }
    public void addKid(Kid kid) {
        if (data.size() < capacity) {
            data.add(kid);
        }
    }
    public boolean removeKid(String name) {
        for (Kid kid : data) {
            if (kid.getName().equals(name)) {
                data.remove(kid);
                return true;
            }
        }
        return false;
    }
    public Kid getKid(String street) {
        for (Kid kid : data) {
            if (kid.getStreet().equals(street)) {
                return kid;
            }
        }
        return null;
    }
    public int getAllKids() {
        return data.size();
    }
    public String getStatistics() {
        StringJoiner sj = new StringJoiner("\n");
        sj.add("Children who visited a house for candy:");
        for (Kid kid : data) {
            sj.add(kid.getName() + " from " + kid.getStreet() + " street");
        }
        return sj.toString();
    }
}