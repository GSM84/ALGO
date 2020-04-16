package Lesson5;

public class Power {
    public static void main(String[] args) {
        System.out.println(powerRecursion(2,4));
    }

    public static double powerRecursion(double _digit, int _power){
        if(_power == 1){
            return _digit;
        } else {
            return _digit * powerRecursion(_digit, _power - 1);
        }
    }
}
