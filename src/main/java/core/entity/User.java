package core.entity;

public class User {

    private final String firstName;
    private final String lastName;
    private final int amountOfMoney;

    public User(String firstName, String lastName, int amountOfMoney) {
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

    public int getAmountOfMoney() {
        return amountOfMoney;
    }
}
