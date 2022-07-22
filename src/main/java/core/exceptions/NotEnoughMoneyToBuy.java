package core.exceptions;

public class NotEnoughMoneyToBuy extends RuntimeException{

    public NotEnoughMoneyToBuy(String message) {
        super(message);
    }
}
