package fr.flaurens.bankaccount.domain.model;

public class UnknownOperationTypeException extends Exception {

    private static final long serialVersionUID = 72188153777893558L;

    public UnknownOperationTypeException(){
        super();
    }

    public UnknownOperationTypeException(String message) {
        super(message);

    }

    public UnknownOperationTypeException(String message, Throwable cause) {
        super(message, cause);

    }

    public UnknownOperationTypeException(Throwable cause) {
        super(cause);

    }

}





