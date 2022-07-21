package core.entity;

import java.math.BigInteger;

public class User {

    private final String firstName;
    private final String lastName;
    private final BigInteger amountOfMoney;

    public User(String firstName, String lastName, BigInteger amountOfMoney) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public BigInteger getAmountOfMoney() {
        return amountOfMoney;
    }
}
