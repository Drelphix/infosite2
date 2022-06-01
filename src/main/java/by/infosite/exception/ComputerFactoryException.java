package by.infosite.exception;

import java.security.PrivilegedActionException;

public class ComputerFactoryException extends Exception{
    public ComputerFactoryException() {
        super();
    }

    public ComputerFactoryException(String message) {
        super(message);
    }

    public ComputerFactoryException(String message, Throwable cause) {
        super(message, cause);
    }

    public ComputerFactoryException(Throwable cause) {
        super(cause);
    }
}
