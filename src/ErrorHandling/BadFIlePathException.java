package ErrorHandling;

public class BadFIlePathException extends RuntimeException {
    public BadFIlePathException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
