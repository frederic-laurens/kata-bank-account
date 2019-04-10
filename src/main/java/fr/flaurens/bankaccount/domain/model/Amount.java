package fr.flaurens.bankaccount.domain.model;

import java.util.Objects;

import static fr.flaurens.bankaccount.domain.model.InvalidAmountException.NEGATIVE_AMOUNT;
import static fr.flaurens.bankaccount.domain.model.InvalidAmountException.NULL_AMOUNT;
import static fr.flaurens.bankaccount.domain.model.InvalidAmountException.ZERO_AMOUNT;

public class Amount {

    private final Double value;

    public Amount(Double value) throws InvalidAmountException {
        if(value == null){
            throw new InvalidAmountException("Amount is NULL", NULL_AMOUNT);
        } else if(value < 0){
            throw new InvalidAmountException("Amount is negative: "+value, NEGATIVE_AMOUNT);
        } else if(value == 0){
            throw new InvalidAmountException("Amount is 0", ZERO_AMOUNT);
        } else {
            this.value = value;
        }
    }

    public Double getAmountValue(){
        return this.value;
    }

    @Override
    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof Amount)){
            return false;
        }
        Amount other = (Amount) object;
        return this.getAmountValue().equals(other.getAmountValue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.value);
    }
}
