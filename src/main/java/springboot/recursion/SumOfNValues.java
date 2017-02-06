package springboot.recursion;

public class SumOfNValues {

    public int count(int i) {

        if (i < 2) {
            return i;
        } else {
            return i + count(i - 1);
        }
    }
}
