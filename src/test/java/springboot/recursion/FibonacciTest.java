package springboot.recursion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class FibonacciTest {

    private Fibonacci fibonacci = new Fibonacci();

    @Test
    public void shouldCountFibonacciValues() {
        assertThat(fibonacci.countFor(0)).isEqualTo(0);
        assertThat(fibonacci.countFor(1)).isEqualTo(1);
        assertThat(fibonacci.countFor(2)).isEqualTo(1);
        assertThat(fibonacci.countFor(3)).isEqualTo(2);
        assertThat(fibonacci.countFor(4)).isEqualTo(3);
        assertThat(fibonacci.countFor(5)).isEqualTo(5);
        assertThat(fibonacci.countFor(6)).isEqualTo(8);
    }
}
