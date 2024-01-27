package Workshop;

import java.util.function.Consumer;

public class SmartArray {
    private int[] data;
    private int index;

    public SmartArray() {
       this.data = new int[2];
       this.index = 0;
    }

    private int[] resize(int newSeize) {
        int[] newData = new int[newSeize];
        System.arraycopy(data, 0, newData, 0, index);
        return newData;
    }

    public void add (int element) {
        if (index == data.length) {
            data = resize(data.length * 2);
        }
        data[index] = element;
        index++;
    }
    public int size(){
        return index;
    }
    public int get(int index){
        return data[index];
    }
    public boolean contains(int element) {
        for (int i = 0; i < index; i++) {
            if (data[i] == element) {
                return true;
            }
        }
        return false;
    }
    public int remove(int index) {
        int element = data[index];
        for (int i = index; i < this.index - 1; i++) {
            data[i] = data[i + 1];
        }

        data[this.index - 1] = 0;
        this.index--;
        if (this.index == data.length / 4) {
            data = resize(data.length / 2);
        }
        return element;
    }
    public void add (int index, int element) {
        int lastElement = data[this.index - 1];
        for (int i = this.index - 1; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = element;
        add(lastElement);
    }
    public void forEach (Consumer<Integer> consumer) {
        for (int i = 0; i < this.index; i++) {
            consumer.accept(data[i]);
        }
    }
}