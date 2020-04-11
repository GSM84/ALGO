package Lesson3.Structure;

import java.util.EmptyStackException;

public class Deck<Entity> {
    private Entity[] list;

    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    private int begin = 0;
    private int end = 0;

    public Deck(int _capacity) {
        if (_capacity <= 0) {
            throw new IllegalArgumentException("Incorrect queue size.");
        }
        list = (Entity[]) new Object[_capacity];
    }

    public Deck() {
        list = (Entity[])new Object[DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public void insert(Entity _entity) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[end] = _entity;
        end = nextIndex(end);
    }

    public void insertFront(Entity _entity) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        for (int i = size - 1; i > begin; i--) {
            list[i] = list[i - 1];
        }

        end = nextIndex(end);

        list[begin] = _entity;
    }

    public Entity removeFront() {
        Entity value = peekFront();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    public Entity removeBack() {
        Entity value = peekBack();
        size--;
        list[end] = null;
        end--;
        return value;
    }

    private int nextIndex(int _index) {
        return (_index + 1) % list.length;
    }

    public Entity peekFront() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }

    public Entity peekBack() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[end - 1];
    }

    public int getSize() {
        return size;
    }

}
