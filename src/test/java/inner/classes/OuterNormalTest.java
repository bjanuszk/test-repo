package inner.classes;

import inner.classes.OuterNormal.InnerNormal;
import org.junit.Test;

public class OuterNormalTest {

    @Test
    public void outerNormalTest() {

        OuterNormal outerNormal = new OuterNormal();
        InnerNormal innerNormal = outerNormal.new InnerNormal();

        innerNormal.printStaticText();
        innerNormal.pringNonStaticText();
    }
}