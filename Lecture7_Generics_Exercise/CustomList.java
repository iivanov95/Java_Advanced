package Lecture7_Generics_Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList <T extends Comparable<T>> implements Iterable<T> {

    private List<T> data;

    public CustomList() {
        this.data = new ArrayList<>();
    }
    public void add(T element) {
        this.data.add(element);
    }
    public T remove (int index) {
        checkIndex(index);
        return this.data.remove(index);
    }

    public boolean contains (T element) {
        return this.data.contains(element);
    }

    public void swap(int index1, int index2) {
        checkIndex(index1);
        checkIndex(index2);
        T firstElement = data.get(index1);
        T secondElement = data.get(index2);

        this.data.set(index1, secondElement);
        this.data.set(index2, firstElement);
    }

    public int getSize() {
        return this.data.size();
    }

    public int countGreaterThan(T element) {
        int count = 0;
        for (T e : this.data) {
            int result = e.compareTo(element);
            if (result > 0) {
                count++;
            }
        }
        return count;
    }

    public T getMax() {
        checkEmpty();
        return Collections.max(this.data);
    }

    public T getMin() {
        checkEmpty();
        // return Collections.min(this.data);
        // или

        T min = this.data.get(0);
        for (T element : this.data) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }

    private void checkEmpty() {
        if (this.data.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
    }

    private void checkIndex(int index) {
        if (index <0 || index >= data.size()) {
            throw new IndexOutOfBoundsException(
                    String.format("Index %d is out of bounds for for size %d.", index, this.data.size())
            );
        }
    }

    public T get(int index) {
        return this.data.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
