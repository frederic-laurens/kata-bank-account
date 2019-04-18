package fr.flaurens.bankaccount.domain.model;

public class AccountNotFoundException extends Exception {

    private static final long serialVersionUID = 72187302277893558L;

    public AccountNotFoundException (){
        super();
    }

    public AccountNotFoundException (String message) {
        super(message);

    }

    public AccountNotFoundException (String message, Throwable cause) {
        super(message, cause);

    }

    public AccountNotFoundException (Throwable cause) {
        super(cause);

    }

}
