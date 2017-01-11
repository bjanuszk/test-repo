package hello;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationTest {

    @Test
    public void shouldPass() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void shouldFail() {
        Assert.assertEquals(0, 1);
    }
}
