package hello.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({Suite1.class, Suite2.class})
public class SuiteComposite {
}
