package springboot.recursion;

public class Fibonacci {

    public int countFor(int n) {
        return n < 2 ? n : (countFor(n - 1) + countFor(n - 2));
    }
}
