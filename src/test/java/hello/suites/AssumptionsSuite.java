package hello.suites;

import static org.junit.Assume.assumeThat;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AssumptionsSuite {

    @Test
    public void assumptionTest() {

        assumeThat(File.separatorChar, CoreMatchers.is("\\"));

        Path path = Paths.get("home", "bjanuszk", "Documents");

        Assert.assertThat("home\\bjanuszk\\Documents", CoreMatchers.is(path));
    }
}
