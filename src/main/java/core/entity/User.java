package core.entity;

import java.math.BigDecimal;

public class User {

    private final String firstName;
    private final String lastName;
    private final BigDecimal amountOfMoney;

    public User(String firstName, String lastName, BigDecimal amountOfMoney) {
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

    public BigDecimal getAmountOfMoney() {
        return amountOfMoney;
    }
}
