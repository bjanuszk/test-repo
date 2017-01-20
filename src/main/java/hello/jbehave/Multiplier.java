package hello.jbehave;

public class Multiplier {

    private int x;
    private int y;

    public void setX(final int x) {
        this.x = x;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int multiply() {
        return x * y;
    }
}
