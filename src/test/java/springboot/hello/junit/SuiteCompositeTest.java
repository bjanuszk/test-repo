package springboot.hello.junit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Suite1Test.class, Suite2Test.class})
public class SuiteCompositeTest {
}
