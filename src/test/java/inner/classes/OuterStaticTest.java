package inner.classes;

import inner.classes.OuterStatic.InnerStatic;
import org.junit.Test;

public class OuterStaticTest {

    @Test
    public void outerStaticTest(){

        new OuterStatic();

        InnerStatic innerStatic = new InnerStatic();
        innerStatic.printStaticText();
        innerStatic.pringNonStaticText();
    }
}