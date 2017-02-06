package res.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ResourceFinder {

    public void readResources() {
        readResource(getClass().getResourceAsStream("data/resource.txt"));
        readResource(getClass().getResourceAsStream("/data/resource.txt"));
        readResource(getClass().getClassLoader().getResourceAsStream("resource.txt"));
        readResource(getClass().getClassLoader().getResourceAsStream("data/resource.txt"));
        readResource(getClass().getClassLoader().getResourceAsStream("/tmp/resource.txt"));
    }

    private void readResource(final InputStream resourceAsStream) {
        if (resourceAsStream != null) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resourceAsStream));
            bufferedReader.lines().forEach(line -> System.out.println(line));
        } else {
            System.out.println("Resource is null !");
        }
    }
}
