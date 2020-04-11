package Lesson3.Structure;

import java.util.EmptyStackException;

public class CSTQueue<Entity> {
    private Entity[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    private int begin = 0;
    private int end = 0;

    public CSTQueue(int _capacity) {
        if (_capacity <= 0) {
            throw new IllegalArgumentException("Incorrect queue size.");
        }
        list = (Entity[]) new Object[_capacity];
    }

    public CSTQueue() {
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

    public Entity remove() {
        Entity value = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

    private int nextIndex(int _index) {
        return (_index + 1) % list.length;
    }

    public Entity peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[begin];
    }
}
