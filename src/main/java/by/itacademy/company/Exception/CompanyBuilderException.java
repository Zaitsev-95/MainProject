package by.itacademy.company.Exception;

public class CompanyBuilderException extends Exception {
    public CompanyBuilderException(Throwable cause) {
        super(cause);
    }

    public CompanyBuilderException(String message) {
        super(message);
    }
}