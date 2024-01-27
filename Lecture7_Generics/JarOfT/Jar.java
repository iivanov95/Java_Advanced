package Lecture7_Generics.JarOfT;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public void add (T element) {
        stack.push(element);
    }

    public T remove (int i) {
        return stack.pop();
    }
}
