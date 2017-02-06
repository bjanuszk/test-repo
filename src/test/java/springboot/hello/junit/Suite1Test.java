package springboot.hello.junit;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import java.util.ArrayList;

public class Suite1Test {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    @Rule
    public Timeout timeout = Timeout.seconds(2);

    @Test
    public void shouldPass() {
        Assert.assertEquals(1, 1);
    }

    @Test
    public void alsoShouldPass() {
        assertThat("Kopytko").contains("pytko");
    }

    @Test
    public void testException() {

        expectedException.expect(IndexOutOfBoundsException.class);
        expectedException.expectMessage("Index: 2");

        new ArrayList<>().get(2);

    }

}
