package Lesson6.Structure.Tree;

public class IllegalLevelException extends Exception {
    private String message;
    public IllegalLevelException(String _message) {
        this.message = _message;
    }
}
