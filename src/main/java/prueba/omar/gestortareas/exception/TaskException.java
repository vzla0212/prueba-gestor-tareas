package prueba.omar.gestortareas.exception;

public class TaskException extends RuntimeException {
    public TaskException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public TaskException(String errorMessage) {
        super(errorMessage);
    }
}
