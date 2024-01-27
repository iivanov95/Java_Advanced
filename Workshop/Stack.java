package Workshop;

import java.util.function.Consumer;

public class Stack {
    private Node top;
    private int size;
    private static class Node {
        private int val;
        private Node prev;
        public Node(int val, Node prev) {
            this.val = val;
            this.prev = prev;
        }
    }

    public void push (int element) {
        top = new Node(element, top);
        size++;
    }
    public int pop () {
        int val = top.val;
        top = top.prev;
        size--;
        return val;
    }
    public int peek() {
        return top.val;
    }
    public void forEach(Consumer<Integer> consumer) {
        Node last = top;
        while (last != null) {
            consumer.accept(last.val);
            last = last.prev;
        }
    }
}