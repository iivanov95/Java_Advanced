package Lecture8_IteratorsAndComparatorsExercise.StackIterator;

public class StackIterator implements Iterable<Integer> {
    private Integer[] elements;
    private int currentIndex;

    public StackIterator() {
        this.elements = new Integer[20];
        this.currentIndex = 0;
    }
    public void push (int element) {
        this.elements[this.currentIndex++] = element;
    }
    public Integer pop () {
        if (currentIndex == 0) {
            throw new IllegalStateException("No elements");
        }
        Integer element = this.elements[this.currentIndex - 1];
        this.elements[this.currentIndex - 1] = null;
        this.currentIndex--;
        return element;
    }

    @Override
    public java.util.Iterator<Integer> iterator() {
        return new java.util.Iterator<Integer>() {
            int index = currentIndex - 1;
            @Override
            public boolean hasNext() {
                return index >= 0;
            }

            @Override
            public Integer next() {
                return elements[index--];
            }
        };
    }
}