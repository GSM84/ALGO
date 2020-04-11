package Lesson3.Structure;

import java.util.EmptyStackException;

public class CSTStack<Entity> {
    private Entity[] list;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public CSTStack(int _capacity) {
        if (_capacity <= 0) {
            throw new IllegalArgumentException("Incorrect stack size.");
        }
        list = (Entity[]) new Object[_capacity];
    }

    public CSTStack() {
        list = (Entity[])new Object[DEFAULT_CAPACITY];
    }

    public void push(Entity _entity) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        list[size] = _entity;
        size++;
    }

    public Entity pop() {
        Entity temp = peek();
        list[--size] = null;
        return temp;
    }

    public Entity peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return list[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    public int getSize() {
        return size;
    }
}

