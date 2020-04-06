package Lesson3;

import java.util.Stack;

public class Reverse {
    private Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        Reverse test = new Reverse();

        test.reverse("Негра манит аргентина");

    }

    public void reverse(String _sentense){
        System.out.println("Source sentense: " + _sentense);
        for (char chr: _sentense.toCharArray()) {
            stack.push(chr);
        }
        System.out.print("Reversed sentense: ");
        while (stack.size() > 0){
            System.out.print(stack.pop());
        }
    }

}
