package fr.flaurens.bankaccount.domain.model;

public class InvalidAmountException extends Exception {

    private static final long serialVersionUID = 7218828562147893558L;

    private final String errorCode;

    public static final String NULL_AMOUNT = "NULL_AMOUNT";
    public static final String ZERO_AMOUNT = "ZERO_AMOUNT";
    public static final String NEGATIVE_AMOUNT = "NEGATIVE_AMOUNT";

    public InvalidAmountException(String errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public InvalidAmountException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidAmountException(String message, Throwable cause, String errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public InvalidAmountException(Throwable cause, String errorCode) {
        super(cause);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return this.errorCode;
    }
}





