package core.exceprions;

public class NotEnoughMoneyToBuy extends RuntimeException{

    public NotEnoughMoneyToBuy(String message) {
        super(message);
    }
}
