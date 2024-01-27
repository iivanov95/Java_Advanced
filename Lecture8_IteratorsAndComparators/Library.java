package Lecture8_IteratorsAndComparators;

import java.util.Arrays;
import java.util.Iterator;

public class Library implements Iterable<Book> {
    private Book[] books;

    public Library(Book... books) {
        this.books = books;
    }
    public int size() {
        return books.length;
    }
    public Book get(int index) {
        return books[index];
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibIterator();
    }
    private class LibIterator implements Iterator<Book> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Book next() {
            return null;
        }
    }
}
