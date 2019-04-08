package fr.flaurens.bankaccount.domain.model;

public class Client {

    private final long clientId;

    private final String firstName;

    private final String lastName;

    public Client(long clientId, String firstName, String lastName){
        this.clientId = clientId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
