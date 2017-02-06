package springboot.recursion;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SumOfNValuesTest {

    private SumOfNValues sumOfNValues = new SumOfNValues();

    @Test
    public void shouldSumNNextValues() {
        assertThat(sumOfNValues.count(0)).isEqualTo(0);
        assertThat(sumOfNValues.count(1)).isEqualTo(1);
        assertThat(sumOfNValues.count(2)).isEqualTo(3);
        assertThat(sumOfNValues.count(3)).isEqualTo(6);
        assertThat(sumOfNValues.count(4)).isEqualTo(10);
        assertThat(sumOfNValues.count(5)).isEqualTo(15);
        assertThat(sumOfNValues.count(6)).isEqualTo(21);
    }
}