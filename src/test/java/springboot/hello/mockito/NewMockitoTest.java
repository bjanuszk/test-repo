package springboot.hello.mockito;


import static org.hamcrest.CoreMatchers.is;

import springboot.hello.junitmockito.Calculator;
import springboot.hello.junitmockito.FinalCalculator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

//@RunWith(MockitoJUnitRunner.class)
public class NewMockitoTest {

    @Mock Calculator calculator;
    @Mock FinalCalculator finalCalculator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void bddMockitoTest() {
        BDDMockito.given(calculator.sum(1, 2)).willReturn(500);
        BDDMockito.given(calculator.sum(1, 4)).willReturn(50);

        Assert.assertThat(calculator.sum(1, 2), is(500));
        BDDMockito.then(calculator).should().sum(1, 2);
    }

    @Test
    public void mockFinalClass() {
        BDDMockito.given(finalCalculator.sum(1, 2)).willReturn(123);

        Assert.assertThat(finalCalculator.sum(1, 2), is(123));
    }


}
