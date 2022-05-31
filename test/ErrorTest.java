import ErrorHandling.BadFIlePathException;
import Reader.FReader;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class ErrorTest {

    private static final String PATH = "myBestPath/trololo";
    private static final String FILE_NAME = "trololo";

    @Test
    public void errorOutput() {
        try {
            // Open file (file is open)
            FReader file = new FReader(PATH);
            // Now file is open => file block now)
            file.openFile(FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void tryWithResource() {
        try (FReader file = new FReader(PATH)) {
            System.out.println("Do something...");
            file.openFile(FILE_NAME);
        } catch (FileNotFoundException e) {
            System.out.println("some kind of exception...");
        }
    }

    @Test(expectedExceptions = BadFIlePathException.class)
    public void myException() {
        try {
            FReader file = new FReader(PATH);
            // Now file is open => file block now)
            file.openFile(FILE_NAME);
        } catch (FileNotFoundException e) {
            throw new BadFIlePathException("Can't open file " + FILE_NAME, e);
        }
    }
}
