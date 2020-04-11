package Lesson3.Structure;

public class Test {
    public static void main(String[] args) {
        Deck<Integer> d = new Deck<>();

        d.insert(1);
        d.insert(2);
        d.insert(3);
        d.insert(4);
        d.insertFront(5);
        d.insert(6);

        int t = d.getSize();
        for (int i = 0; i < t; i++) {
            System.out.println(d.removeBack());
        }

    }
}
