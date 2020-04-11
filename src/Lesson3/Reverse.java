package Lesson3;

import java.util.Stack;

public class Reverse {
    private Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {
        Reverse test = new Reverse();

        System.out.println(test.reverse("Негра манит аргентина"));

    }

    public String reverse(String _sentense){
        for (char chr: _sentense.toCharArray()) {
            stack.push(chr);
        }

        StringBuilder sb = new StringBuilder();
        while (stack.size() > 0){
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
