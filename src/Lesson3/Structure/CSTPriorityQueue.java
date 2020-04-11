package Lesson3.Structure;

import java.util.EmptyStackException;

public class CSTPriorityQueue<Entity extends Comparable> {
    private Entity[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 10;

    public CSTPriorityQueue(int _capacity) {
        if (_capacity <= 0) {
            throw new IllegalArgumentException("Incorrect queue size.");
        }
        list = (Entity[]) new Object[_capacity];
    }

    public CSTPriorityQueue() {
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
        list[size] = _entity;
        size++;
        int i = size - 1;

        while (i > 0 && list[i].compareTo(list[i - 1]) < 0) {
            exchange(i, i - 1);
            i--;
        }
    }

    public Entity remove() {
        Entity temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    private int nextIndex(int _index) {
        return (_index + 1) % list.length;
    }

    public Entity peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    private void exchange(int _index1, int _index2) {
        Entity temp = list[_index1];
        list[_index1] = list[_index2];
        list[_index2] = temp;
    }
}
