package springboot.hello.jbehave;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class MultiplierSteps {

    private Multiplier multiplier;

    @Given("a multiplier")
    public void createMultilpier() {
        multiplier = new Multiplier();
    }

    @When("I multiply $x and $y")
    public void setupMultiplier(int x, int y) {
        multiplier.setX(x);
        multiplier.setY(y);
    }

    @Then("The result is $expected")
    public void theResultIs(int expected) {
        assertThat(multiplier.multiply(), CoreMatchers.is(expected));
    }
}
