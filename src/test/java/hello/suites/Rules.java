package hello.suites;

import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExternalResource;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class Rules {

    @Rule public TemporaryFolder temporaryFolder = new TemporaryFolder();
    @Rule public TestName testName = new TestName();
    @Rule public ExternalResource externalResource = new ExternalResource() {
        @Override
        public Statement apply(final Statement base, final Description description) {
            return super.apply(base, description);
        }

        @Override
        protected void before() throws Throwable {
            System.out.println("My rule before");
            super.before();
        }

        @Override
        protected void after() {
            System.out.println("My rule after");
            super.after();
        }
    };

    @Test
    public void shouldWriteDataToTemporaryFile() throws IOException {
        File temporaryFile = temporaryFolder.newFile();
        System.out.println("Absolute path: " + temporaryFile.getAbsolutePath());

        Files.write(temporaryFile.toPath(), newArrayList("test input"));

        List<String> content = Files.readAllLines(temporaryFile.toPath());
        assertThat(content.get(0), CoreMatchers.is("test input"));
    }

    @Test
    public void testNameRuleTest() {
        System.out.println(testName.getMethodName());
    }
}
