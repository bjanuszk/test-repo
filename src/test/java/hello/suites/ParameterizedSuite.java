package hello.suites;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import hello.fortest.Calculator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class ParameterizedSuite {

    @Parameters(name = "{index}: sum({0}+{1})={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0, 0, 0}, {1, 4, 5}, {3, 4, 7}
        });
    }

    @Parameter(value = 0) public int a;
    @Parameter(value = 1) public int b;
    @Parameter(value = 2) public int sum;

    private Calculator calculator = new Calculator();

    @Test
    public void shouldComputeSumOfTwoIntegers() {
        assertThat(sum, is(calculator.sum(a, b)));
    }
}
