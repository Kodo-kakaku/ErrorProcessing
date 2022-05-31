package Reader;

import java.io.FileNotFoundException;

public class FReader implements AutoCloseable {
    private boolean testFlag = false;
    private static final String OPEN_FILE = "File is open!";
    private static final String CLOSE_FILE = "File is close!";
    private static final String OPERATION_BLOCK = "Operation is blocked!";

    public FReader(String path) throws FileNotFoundException {
        this.openFile(path);
    }

    public void openFile(String path) throws FileNotFoundException {
        if (this.testFlag) {
            throw new FileNotFoundException(OPERATION_BLOCK);
        }

        this.testFlag = true;
        System.out.println(OPEN_FILE);
    }

    @Override
    public void close() {
        this.testFlag = false;
        System.out.println(CLOSE_FILE);
    }
}
